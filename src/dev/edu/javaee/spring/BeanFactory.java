package dev.edu.javaee.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	public Object getBean(String beanName)
	{
		return this.beanDefinitionMap.get(beanName).getBean();
	}
	
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
	{
		this.beanDefinitionMap.put(beanName, beanDefinition);
	}
}
