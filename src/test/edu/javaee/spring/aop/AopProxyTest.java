package test.edu.javaee.spring.aop;

import org.junit.Test;

import dev.edu.javaee.spring.aop.AdvisedSupport;
import dev.edu.javaee.spring.aop.AopProxy;
import dev.edu.javaee.spring.aop.MethodMatcher;
import dev.edu.javaee.spring.aop.NameMatchMethodPointcut;
import dev.edu.javaee.spring.aop.TargetSource;

public class AopProxyTest {
	
	@Test
	public void TestStaticProxy()
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
}
