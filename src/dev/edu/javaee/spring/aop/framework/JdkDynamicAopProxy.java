package dev.edu.javaee.spring.aop.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dev.edu.javaee.spring.aop.AfterReturningAdvice;
import dev.edu.javaee.spring.aop.AopProxy;
import dev.edu.javaee.spring.aop.MethodBeforeAdvice;
import dev.edu.javaee.spring.aop.ThrowsAdvice;

public class JdkDynamicAopProxy implements AopProxy, InvocationHandler{

	private AdvisedSupport advised;
	
	public JdkDynamicAopProxy(AdvisedSupport advised)
	{
		this.advised = advised;
	}
	
	public Object getProxy()
	{
//		System.out.println(object.getClass());
//		System.out.println(objectClass);
		return Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				new Class[]{advised.getInterfaces()}, 
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass()))
		{
			if(advised.getAdvice() instanceof MethodBeforeAdvice)
			{
				MethodBeforeAdvice methodBeforeAdvice = (MethodBeforeAdvice)advised.getAdvice();
				methodBeforeAdvice.before(method, args, advised.getTargetSource().getTarget());
				return method.invoke(advised.getTargetSource().getTarget(), args);
			}
			if(advised.getAdvice() instanceof AfterReturningAdvice)
			{
				AfterReturningAdvice afterReturningAdvice = (AfterReturningAdvice)advised.getAdvice();
				Object returnValue = method.invoke(advised.getTargetSource().getTarget(), args);
				afterReturningAdvice.afterReturning(returnValue, method, args, advised.getTargetSource().getTarget());
				return returnValue;
			}
			if(advised.getAdvice() instanceof ThrowsAdvice)
			{
				try {
					Object returnValue = method.invoke(advised.getTargetSource().getTarget(), args);
					return returnValue;
				}
				catch (Throwable ex) {
					//We didn`t define our exceptionHandler for special exceptionClass, just simply throw the exception.
					throw ex;
				}
			}
		}
			
		return method.invoke(advised.getTargetSource().getTarget(), args);
	}

}
