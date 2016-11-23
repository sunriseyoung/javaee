package dev.edu.javaee.spring.aop.framework;

import dev.edu.javaee.spring.aop.Advisor;
import dev.edu.javaee.spring.aop.support.TargetSource;

public class AdvisedSupport {
	private TargetSource targetSource;
	
	private Class<?> interfaces;
	
	private Advisor advisor;
	
	public TargetSource getTargetSource() {
		return targetSource;
	}
	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}
	public void setTarget(Object target) {
		this.targetSource = new TargetSource(target);
	}
	
	public Class<?> getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(Class<?> interfaces) {
		this.interfaces = interfaces;
	}
	public Advisor getAdvisor() {
		return advisor;
	}
	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}
}
