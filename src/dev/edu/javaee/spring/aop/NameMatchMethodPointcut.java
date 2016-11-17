package dev.edu.javaee.spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NameMatchMethodPointcut implements MethodMatcher{
	
	private List<String> mappedNames = new LinkedList<>();
	
	public void setMappedName(String name)
	{
		setMappedNames(name);
	}
	
	public void setMappedNames(String... names)
	{
		mappedNames.addAll(Arrays.asList(names));
	}
	
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		for(String mappedName: mappedNames)
		{
			if(method.getName().equals(mappedName))
				return true;
		}
		return false;
	}
}
