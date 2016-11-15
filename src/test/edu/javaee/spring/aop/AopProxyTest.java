package test.edu.javaee.spring.aop;

import org.junit.Test;

import dev.edu.javaee.spring.aop.AopProxy;
import dev.edu.javaee.spring.aop.ISubject;

public class AopProxyTest {
	
	@Test
	public void TestStaticProxy()
	{
		ISubject subject = new AopProxy(new RealSubject());
		subject.printFirstMessage();
		subject.printSecondMessage();
	}
}
