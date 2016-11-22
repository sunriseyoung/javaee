package dev.edu.javaee.spring.aop.framework;

import dev.edu.javaee.spring.aop.Advice;
import dev.edu.javaee.spring.aop.MethodMatcher;
import dev.edu.javaee.spring.aop.support.TargetSource;

public class AdvisedSupport {
	private TargetSource targetSource;
	
	private Class<?> interfaces;
	
	private MethodMatcher methodMatcher;
	
	private Advice advice;
	
	public TargetSource getTargetSource() {
		return targetSource;
	}
	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}
	
	public MethodMatcher getMethodMatcher() {
		return methodMatcher;
	}
	public void setMethodMatcher(MethodMatcher methodMatcher) {
		this.methodMatcher = methodMatcher;
	}
	public Class<?> getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(Class<?> interfaces) {
		this.interfaces = interfaces;
	}
	public Advice getAdvice() {
		return advice;
	}
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
}
