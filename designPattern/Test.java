package designPattern;

public class Test {

	public static void main(String[] args){

		for(int i=0;i<100;i++) {
			new Thread(()->{
					try {
						Singalton singaltont1 = Singalton.getInstance();
						System.out.println(singaltont1.hashCode());
					} catch (Exception e) {
						e.printStackTrace();
					}
//					System.out.print(j+" ");
			}).start();
		}
		
	}

}
