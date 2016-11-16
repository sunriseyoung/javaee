package dev.edu.javaee.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopProxy implements InvocationHandler{

	private Object target;
	
	private Class<?> targetClass;
	
	private MethodInterceptor methodInterceptor;
	
	public AopProxy(Object target, Class<?> targetClass, MethodInterceptor methodInterceptor)
	{
		this.target = target;
		this.targetClass = targetClass;
		this.methodInterceptor = methodInterceptor;
	}
	
	public Object getProxy()
	{
//		System.out.println(object.getClass());
//		System.out.println(objectClass);
		return Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				new Class[]{targetClass}, 
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		return methodInterceptor.invoke(target,method,args);
	}

}
