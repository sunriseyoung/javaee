package dev.edu.javaee.spring.aop;

public interface PointcutAdvisor extends Advisor {
	Pointcut getPointcut();
}
