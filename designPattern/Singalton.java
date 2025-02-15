package com.dpk;

import java.io.Serializable;

public class Singalton implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Singalton instance;
	private static boolean flag=false;
	
	public Singalton() throws Exception {
		if(flag) {
			throw new Exception("already obj exsisit");
		}
//		super();
		System.out.println("constructor called");
	}



	public static Singalton getInstance() throws Exception {
		if(instance==null) {
			flag=true;
			return instance=new Singalton();
		}
		return instance;
	}
}
