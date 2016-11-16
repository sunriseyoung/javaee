package dev.edu.javaee.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class AopProxy implements InvocationHandler{

	private Object object;
	
	private Class<?> objectClass;
	
	public AopProxy(Object object, Class<?> objectClass)
	{
		this.object = object;
		this.objectClass = objectClass;
	}
	
	public Object getProxy()
	{
//		System.out.println(object.getClass());
//		System.out.println(objectClass);
		return Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				new Class[]{objectClass}, 
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("The Log Start");
		return method.invoke( object, args);
	}

}
