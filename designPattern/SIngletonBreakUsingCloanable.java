package com.dpk;

public class SIngletonBreakUsingCloanable {

	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonClonable instance = SingletonClonable.getIntance();
		SingletonClonable instance2 = (SingletonClonable) instance.clone();
		
		System.out.println(instance.hashCode());
		System.out.println(instance2.hashCode());
	}
}
