package dev.edu.javaee.spring.factory;

import java.lang.reflect.Field;
import java.util.List;

import dev.edu.javaee.spring.bean.BeanDefinition;
import dev.edu.javaee.spring.bean.PropertyValue;

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
			
			List<PropertyValue> fieldDefinitionList = beanDefinition.getPropertyValues().GetPropertyValues();
			for(PropertyValue fieldDef: fieldDefinitionList)
			{
				try {
					Field field = beanClass.getDeclaredField(fieldDef.getName());
					field.setAccessible(true);
					field.set(bean, fieldDef.getValue());
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
