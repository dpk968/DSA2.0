package tree;

import java.util.ArrayList;

public class Path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);

		
		System.out.println("LCA");
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		getPath(root,7,arr);
		
		System.out.println("arr-:>"+arr);
		
	}

	private static boolean getPath(Node root, int x, ArrayList<Integer>  arr) {
		// TODO Auto-generated method stub
		if(root == null) return false;
		
		arr.add(root.data);
		
		if(root.data == x) {
			return true;
		}
		
		if(getPath(root.left,x,arr) || getPath(root.right, x, arr))
			return true;
		
		arr.remove(arr.size()-1);
		
		return false;
		
	}

}
