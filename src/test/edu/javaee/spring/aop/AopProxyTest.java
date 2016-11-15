package test.edu.javaee.spring.aop;

import java.lang.reflect.Proxy;

import org.junit.Test;

import dev.edu.javaee.spring.aop.AopProxy;

public class AopProxyTest {
	
	@Test
	public void TestStaticProxy()
	{
		ISubject subject = (ISubject) Proxy.newProxyInstance(
				ISubject.class.getClassLoader(), 
				new Class[] { ISubject.class },
				new AopProxy(new RealSubject()));
		
		subject.printFirstMessage();
		subject.printSecondMessage();
	}
}
