package test.edu.javaee.spring.aop;

import org.junit.Test;

import dev.edu.javaee.spring.aop.MethodMatcher;
import dev.edu.javaee.spring.aop.framework.AopProxy;
import dev.edu.javaee.spring.aop.support.AdvisedSupport;
import dev.edu.javaee.spring.aop.support.JdkRegexpMethodPointcut;
import dev.edu.javaee.spring.aop.support.NameMatchMethodPointcut;
import dev.edu.javaee.spring.aop.support.TargetSource;

public class AopProxyTest {
	
	@Test
	public void TestNameMatchMethodPointcut()
	{
		ISubject realSubject = new RealSubject();
		
		TargetSource targetSource = new TargetSource();
		targetSource.setTarget(realSubject);
		targetSource.setTargetClass(ISubject.class);
		
		AdvisedSupport advised = new AdvisedSupport();
		advised.setTargetSource(targetSource);
		advised.setMethodInterceptor(new SimpleLogInterceptor());
		NameMatchMethodPointcut methodMatcher = new NameMatchMethodPointcut();
		methodMatcher.setMappedName("printSecondMessage");
		advised.setMethodMatcher(methodMatcher);
		
		AopProxy proxy = new AopProxy(advised);
		ISubject subjectProy = (ISubject) proxy.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
	
	@Test
	public void TestJdkRegexpMethodPointcut()
	{
		ISubject realSubject = new RealSubject();
		
		TargetSource targetSource = new TargetSource();
		targetSource.setTarget(realSubject);
		targetSource.setTargetClass(ISubject.class);
		
		AdvisedSupport advised = new AdvisedSupport();
		advised.setTargetSource(targetSource);
		advised.setMethodInterceptor(new SimpleLogInterceptor());
		JdkRegexpMethodPointcut methodMatcher = new JdkRegexpMethodPointcut();
		methodMatcher.setPattern("printSecond\\w+");
		advised.setMethodMatcher(methodMatcher);
		
		AopProxy proxy = new AopProxy(advised);
		ISubject subjectProy = (ISubject) proxy.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
}
