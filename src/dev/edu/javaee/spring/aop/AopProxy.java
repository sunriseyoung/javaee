package dev.edu.javaee.spring.aop;

public class AopProxy implements ISubject{

	private ISubject subject;
	
	public AopProxy(ISubject subject)
	{
		this.subject = subject;
	}
	
	@Override
	public void printFirstMessage() {
		System.out.println("before 1st Message");
		subject.printFirstMessage();
	}

	@Override
	public void printSecondMessage() {
		System.out.println("before 2nd Message");
		subject.printSecondMessage();
	}

}
