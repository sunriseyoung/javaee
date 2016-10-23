package dev.edu.javaee.spring.factory;

import dev.edu.javaee.spring.BeanDefinition;

public class XMLBeanFactory extends AbstractBeanFactory{

	@Override
	protected BeanDefinition GetCreatedBean(BeanDefinition beanDefinition) {
		String beanClassName = beanDefinition.getBeanClassName();
		try {
			// set BeanClass for BeanDefinition
			Class<?> beanClass = Class.forName(beanClassName);
			beanDefinition.setBeanClass(beanClass);
			
			// set Bean Instance for BeanDefinition
			Object bean = beanClass.newInstance();
			beanDefinition.setBean(bean);
			
			return beanDefinition;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
