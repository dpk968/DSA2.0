package com.dpk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonBreak {

	public static void main(String[] args) throws Exception {
		Singalton intance1 = Singalton.getInstance();
		System.out.println(intance1.hashCode());
		Constructor<Singalton> constructor = Singalton.class.getDeclaredConstructor();
		
		constructor.setAccessible(true);
		
		Singalton intance2 = constructor.newInstance();
		Singalton intance3 = constructor.newInstance();
		Singalton intance4 = constructor.newInstance();
		
		
	}
}
