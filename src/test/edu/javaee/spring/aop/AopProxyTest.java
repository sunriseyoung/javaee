package test.edu.javaee.spring.aop;

import org.junit.Test;

import dev.edu.javaee.spring.aop.AopProxy;

public class AopProxyTest {
	
	@Test
	public void TestStaticProxy()
	{
		ISubject realSubject = new RealSubject();
		AopProxy proxy = new AopProxy(realSubject, ISubject.class, new SimpleLogInterceptor());
		ISubject subjectProy = (ISubject) proxy.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
}
