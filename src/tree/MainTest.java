package tree;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.err.println("Enter BST data");
		BST tree = new BST();
		
		int data = sc.nextInt();
		
		while(data != -1) {
			tree.add(data);	
			data = sc.nextInt();
		}
		
		
//		tree.inorder(tree.root);
		LevelOrder.levelOrder(tree.root);
		
		sc.close();

	}

}
