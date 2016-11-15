package test.edu.javaee.spring.aop;

import dev.edu.javaee.spring.aop.ISubject;

public class RealSubject implements ISubject{

	@Override
	public void printFirstMessage() {
		System.out.println("First Message");
	}

	@Override
	public void printSecondMessage() {
		System.out.println("Second Message");
	}

}
