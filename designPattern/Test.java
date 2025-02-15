package com.dpk;

public class Test {

	public static void main(String[] args) {

		for(int i=0;i<100;i++) {
			new Thread(()->{
				for(int j=0;j<1000;j++) {
					Singalton singaltont1 = Singalton.getInstance();
//					System.out.print(j+" ");
				}
			}).start();
		}
		
	}

}
