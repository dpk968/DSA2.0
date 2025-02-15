package com.dpk;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.dpk.entity.Employee;

public class MainClass {
	public static void main(String[] args) {
		
		Employee employee = new Employee("dpk", "dpk123", "dpk@gmai.com", "Mathura");
		
		try(FileOutputStream fos = new FileOutputStream(new File("output.txt"))){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employee);
			System.out.println(employee);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
