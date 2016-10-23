package test.edu.javaee.spring;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.edu.javaee.spring.BeanDefinition;
import dev.edu.javaee.spring.factory.BeanFactory;
import dev.edu.javaee.spring.factory.XMLBeanFactory;

public class BeanFactoryTest {

	@Test
	public void testBeanCreateAndGet() {
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("test.edu.javaee.spring.Dishes");
		
		BeanFactory beanFactory = new XMLBeanFactory();
		// the BeanDefinition doesn`t create the real bean yet
		beanFactory.registerBeanDefinition("egg dishes", beanDefinition);
		Dishes d = (Dishes) beanFactory.getBean("egg dishes");
		assertEquals(d.printDishes(), "fry eggs!");
	}

}
