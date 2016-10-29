package test.edu.javaee.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dev.edu.javaee.spring.bean.BeanDefinition;
import dev.edu.javaee.spring.bean.PropertyValue;
import dev.edu.javaee.spring.bean.PropertyValues;
import dev.edu.javaee.spring.factory.BeanFactory;
import dev.edu.javaee.spring.factory.XMLBeanFactory;

public class BeanFactoryTest {

	@Test
	public void testBeanCreateAndGet() {

		BeanFactory beanFactory = new XMLBeanFactory("beans.xml");
		// the BeanDefinition doesn`t create the real bean yet
		Dishes d = (Dishes) beanFactory.getBean("egg dishes");
		assertEquals(d.printDishes(), "Dish Name: fry eggs. Dish Price: 20.");
	}

}
