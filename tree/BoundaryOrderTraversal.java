package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BoundaryOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello ji");
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.right = new Node(4);

		root.right.left = new Node(5);
		root.right.right = new Node(6);

		root.left.right.left = new Node(7);
		root.right.left.right = new Node(8);

		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);

		List<Integer> arr = new LinkedList<>();
		
		
		printboundary(root,arr);
		
		for(int e:arr) {
			System.out.print(e+" ");
		}

	}

	private static void printboundary(Node root, List<Integer> arr) {

		// left wale print kro except leaves node
		printLeftNode(root,arr);

		// leaves kro
		printleaveNodes(root,arr);

		// right wale kro reverse m
		Stack<Integer> st = new Stack<>();
		
		printRightNodes(root.right,st);
		
		while(!st.isEmpty()) {
			arr.add(st.pop());
		}

	}

	private static void printRightNodes(Node root,Stack<Integer> st) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			return;

		
		st.push(root.data);

		if (root.right != null) {
			printLeftNode(root.right,st);
		} else {
			printLeftNode(root.left,st);
		}

	}

	private static void printLeftNode(Node root,List<Integer> arr) {

		if (root == null)
			return;

		if (root.left == null && root.right == null)
			return;

		System.out.print(root.data + " ");

		if (root.left != null) {
			printLeftNode(root.left,arr);
		} else {
			printLeftNode(root.right,arr);
		}

	}

	private static void printleaveNodes(Node root,List<Integer> arr) {

		if (root == null)
			return;

		printleaveNodes(root.left,arr);
		if (root.left == null && root.right == null)
			System.out.print(root.data + " ");
		printleaveNodes(root.right,arr);
	}

}
