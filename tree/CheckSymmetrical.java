package tree;

import java.util.ArrayList;
import java.util.List;

public class CheckSymmetrical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root =  new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(2);
		
//		root.left.left = new Node(3);
		root.left.right = new Node(4);
//		root.right.left = new Node(4);
		root.right.right = new Node(4);
		
		// check inorder traversal 
		List<Integer> arr = new ArrayList<>();
		inOrder(root, arr);
		System.out.println(isSymmertric(arr));
		
		System.out.println(isSymmertric(root));
		
		

	}
	
	private static boolean isSymmertric(Node root) {
		return false;
	}
	
	private static boolean  isSymmertric(List<Integer> arr) {
		if(arr.isEmpty()) return true;
		
		int s = 0;
		int e = arr.size()-1;
		
		while(s<=e) {
			if(arr.get(s) == arr.get(e)) {
				s++;
				e--;
			}else {
				return false;
			}
				
		}
		
		return true;
		
	}

	public static void inOrder(Node root,List<Integer> arr) {
		if(root == null) return;
		
		inOrder(root.left,arr);
		arr.add(root.data);
		inOrder(root.right, arr);
		
	}

}
