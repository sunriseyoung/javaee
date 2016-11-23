package test.edu.javaee.spring.aop;

import org.junit.Test;

import dev.edu.javaee.spring.aop.framework.ProxyFactory;
import dev.edu.javaee.spring.aop.support.JdkRegexpMethodPointcutAdvisor;
import dev.edu.javaee.spring.aop.support.NameMatchMethodPointcutAdvisor;
import dev.edu.javaee.spring.aop.support.TargetSource;

public class AopProxyTest {
	
	@Test
	public void TestNameMatchMethodPointcut()
	{
		ISubject realSubject = new RealSubject();
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(realSubject);
		proxyFactory.setInterfaces(ISubject.class);
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
		advisor.setAdvice(new SimpleLogBeforeMehtod());
		advisor.setMappedName("printSecondMessage");
		proxyFactory.setAdvisor(advisor);
		
		ISubject subjectProy = (ISubject) proxyFactory.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
	
	@Test
	public void TestJdkRegexpMethodPointcut()
	{
		ISubject realSubject = new RealSubject();
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(realSubject);
		proxyFactory.setInterfaces(ISubject.class);
		JdkRegexpMethodPointcutAdvisor advisor = new JdkRegexpMethodPointcutAdvisor();
		advisor.setAdvice(new SimpleLogAfterReturningAdvice());
		advisor.setPattern("printSecond\\w+");
		proxyFactory.setAdvisor(advisor);
		
		ISubject subjectProy = (ISubject) proxyFactory.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
}
