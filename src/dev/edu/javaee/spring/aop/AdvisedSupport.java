package dev.edu.javaee.spring.aop;

public class AdvisedSupport {
	private TargetSource targetSource;
	private MethodInterceptor methodInterceptor;
	
	public TargetSource getTargetSource() {
		return targetSource;
	}
	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}
	public MethodInterceptor getMethodInterceptor() {
		return methodInterceptor;
	}
	public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}
}
