package dev.edu.javaee.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class AopProxy implements InvocationHandler{

	private Object object;
	
	public AopProxy(Object object)
	{
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("The Log Start");
		return method.invoke( object, args);
	}

}
