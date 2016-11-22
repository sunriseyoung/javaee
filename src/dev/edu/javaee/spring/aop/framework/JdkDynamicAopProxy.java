package dev.edu.javaee.spring.aop.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dev.edu.javaee.spring.aop.AfterReturningAdvice;
import dev.edu.javaee.spring.aop.AopProxy;
import dev.edu.javaee.spring.aop.MethodBeforeAdvice;
import dev.edu.javaee.spring.aop.MethodInterceptor;
import dev.edu.javaee.spring.aop.ThrowsAdvice;
import dev.edu.javaee.spring.aop.support.AfterReturningAdviceInterceptor;
import dev.edu.javaee.spring.aop.support.MethodBeforeAdviceInterceptor;
import dev.edu.javaee.spring.aop.support.ThrowsAdviceInterceptor;

public class JdkDynamicAopProxy implements AopProxy, InvocationHandler{

	private AdvisedSupport advised;
	
	public JdkDynamicAopProxy(AdvisedSupport advised)
	{
		this.advised = advised;
	}
	
	public Object getProxy()
	{
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
				MethodBeforeAdvice advice = (MethodBeforeAdvice)advised.getAdvice();
				MethodInterceptor interceptor = new MethodBeforeAdviceInterceptor(advice);
				return interceptor.invoke(advised.getTargetSource().getTarget(), method, args);
			}
			if(advised.getAdvice() instanceof AfterReturningAdvice)
			{
				AfterReturningAdvice advice = (AfterReturningAdvice)advised.getAdvice();
				MethodInterceptor interceptor = new AfterReturningAdviceInterceptor(advice);
				return interceptor.invoke(advised.getTargetSource().getTarget(), method, args);
			}
			if(advised.getAdvice() instanceof ThrowsAdvice)
			{
				ThrowsAdvice advice = (ThrowsAdvice)advised.getAdvice();
				MethodInterceptor interceptor = new ThrowsAdviceInterceptor(advice);
				return interceptor.invoke(advised.getTargetSource().getTarget(), method, args);
			}
		}
			
		return method.invoke(advised.getTargetSource().getTarget(), args);
	}

}
