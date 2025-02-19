package designPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonBreakUsingSeralizable {

	public static void main(String[] args) throws Exception {
		
		Singalton singalton = Singalton.getInstance();

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));

		oos.writeObject(singalton);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));

		Singalton singalton2 = (Singalton) ois.readObject();
		ois.close();

		System.out.println(singalton.hashCode());
		System.out.println(singalton2.hashCode());

	}

}
