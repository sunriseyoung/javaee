package dev.edu.javaee.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopProxy implements InvocationHandler{

	private AdvisedSupport advised;
	
	public AopProxy(AdvisedSupport advised)
	{
		this.advised = advised;
	}
	
	public Object getProxy()
	{
//		System.out.println(object.getClass());
//		System.out.println(objectClass);
		return Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				new Class[]{advised.getTargetSource().getTargetClass()}, 
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		return advised.getMethodInterceptor().invoke(advised.getTargetSource().getTarget(),method,args);
	}

}
