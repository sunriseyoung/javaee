package test.edu.javaee.spring.aop;

import org.junit.Test;

import dev.edu.javaee.spring.aop.AopProxy;
import dev.edu.javaee.spring.aop.MethodMatcher;
import dev.edu.javaee.spring.aop.framework.JdkDynamicAopProxy;
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
		
		AdvisedSupport advised = new AdvisedSupport();
		advised.setTargetSource(targetSource);
		advised.setMethodInterceptor(new SimpleLogInterceptor());
		advised.setInterfaces(ISubject.class);
		NameMatchMethodPointcut methodMatcher = new NameMatchMethodPointcut();
		methodMatcher.setMappedName("printSecondMessage");
		advised.setMethodMatcher(methodMatcher);
		
		AopProxy proxy = new JdkDynamicAopProxy(advised);
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
		
		AdvisedSupport advised = new AdvisedSupport();
		advised.setTargetSource(targetSource);
		advised.setMethodInterceptor(new SimpleLogInterceptor());
		advised.setInterfaces(ISubject.class);
		JdkRegexpMethodPointcut methodMatcher = new JdkRegexpMethodPointcut();
		methodMatcher.setPattern("printSecond\\w+");
		advised.setMethodMatcher(methodMatcher);
		
		AopProxy proxy = new JdkDynamicAopProxy(advised);
		ISubject subjectProy = (ISubject) proxy.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
}
