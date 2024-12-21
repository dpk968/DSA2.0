package tree;

import java.util.ArrayList;
import java.util.List;

public class LCA {

	static List<Integer> path = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(4);

		root.left = new Node(2);
		root.right = new Node(7);

		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		root.right.left = new Node(6);

		System.out.println("LCA");
		
		System.out.println(lca(root,3,6));
		

	}
	
	public static int lca(Node root,int v1,int v2) {
		if(root == null)
			return -1;
		
		if(root.data == v1 || root.data == v2)
			return root.data;
		
		int left = lca(root.left,v1,v2);
		int right = lca(root.right,v1,v2);
		
		if(left == -1) {
			return right;
		}else if(right == -1) {
			return left;
		}else {
			return root.data;
		}
		
		
		
	}

}
