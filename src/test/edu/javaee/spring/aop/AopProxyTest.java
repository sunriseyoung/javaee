package test.edu.javaee.spring.aop;

import org.junit.Test;

import dev.edu.javaee.spring.aop.AopProxy;
import dev.edu.javaee.spring.aop.MethodMatcher;
import dev.edu.javaee.spring.aop.framework.JdkDynamicAopProxy;
import dev.edu.javaee.spring.aop.framework.ProxyFactory;
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
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTargetSource(targetSource);
		proxyFactory.setMethodInterceptor(new SimpleLogInterceptor());
		proxyFactory.setInterfaces(ISubject.class);
		NameMatchMethodPointcut methodMatcher = new NameMatchMethodPointcut();
		methodMatcher.setMappedName("printSecondMessage");
		proxyFactory.setMethodMatcher(methodMatcher);
		
		ISubject subjectProy = (ISubject) proxyFactory.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
	
	@Test
	public void TestJdkRegexpMethodPointcut()
	{
		ISubject realSubject = new RealSubject();
		
		TargetSource targetSource = new TargetSource();
		targetSource.setTarget(realSubject);
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTargetSource(targetSource);
		proxyFactory.setMethodInterceptor(new SimpleLogInterceptor());
		proxyFactory.setInterfaces(ISubject.class);
		JdkRegexpMethodPointcut methodMatcher = new JdkRegexpMethodPointcut();
		methodMatcher.setPattern("printSecond\\w+");
		proxyFactory.setMethodMatcher(methodMatcher);
		
		ISubject subjectProy = (ISubject) proxyFactory.getProxy();
		
		subjectProy.printFirstMessage();
		subjectProy.printSecondMessage();
	}
}
