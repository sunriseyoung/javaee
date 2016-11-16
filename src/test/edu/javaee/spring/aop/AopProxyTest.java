package test.edu.javaee.spring.aop;

import java.lang.reflect.Proxy;

import org.junit.Test;

import dev.edu.javaee.spring.aop.AopProxy;

public class AopProxyTest {
	
	@Test
	public void TestStaticProxy()
	{
		ISubject realSubject = new RealSubject();
		AopProxy proxy = new AopProxy(realSubject, ISubject.class);
		ISubject subjectProy = (ISubject) proxy.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
}
