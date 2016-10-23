package test.edu.javaee.spring;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.edu.javaee.spring.BeanDefinition;
import dev.edu.javaee.spring.BeanFactory;

public class BeanFactoryTest {

	@Test
	public void testBeanCreateAndGet() {
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBean(new Dishes());
		
		BeanFactory beanFactory = new BeanFactory();
		beanFactory.registerBeanDefinition("egg dishes", beanDefinition);
		Dishes d = (Dishes) beanFactory.getBean("egg dishes");
		assertEquals(d.printDishes(), "fry eggs!");
	}

}
