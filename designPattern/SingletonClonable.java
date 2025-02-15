package com.dpk;

public class SingletonClonable implements Cloneable{

	private static SingletonClonable intance;
	
	public static SingletonClonable getIntance() {
		if(intance==null) {
			return intance = new SingletonClonable();
		}
		return intance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
