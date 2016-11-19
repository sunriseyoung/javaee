package dev.edu.javaee.spring.aop;

import java.lang.reflect.Method;

public abstract class StaticMethodMatcher implements MethodMatcher {
	public boolean mathcer(Method method, Class<?> targetClass, Object... args)
	{
		throw new UnsupportedOperationException("Illegal MethodMatcher usage");
	}
	public boolean isRuntime()
	{
		return false;
	}
}
