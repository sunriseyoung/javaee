package dev.edu.javaee.spring.aop;

public abstract class AbstractPointcutAdvisor implements PointcutAdvisor {

	private Advice advice;
	
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
	@Override
	public Advice getAdvice() {
		// TODO Auto-generated method stub
		return advice;
	}
}
