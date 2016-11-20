package dev.edu.javaee.spring.aop.support;

public class TargetSource {
	private Object target;
	private Class<?> targetClass;

	public TargetSource() {
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Class<?> getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(Class<?> targetClass) {
		this.targetClass = targetClass;
	}
}