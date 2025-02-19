package designPattern;

import java.lang.reflect.Constructor;

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
