package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

	public static void main(String[] args) {

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
		
		levelOrder(root);

	}
	
	public static void levelOrder(Node root) {
		if(root == null) return;
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(root);
		q.add(null);
		
		while (!q.isEmpty()) {
			
			Node tmp = q.poll();
			if(tmp == null) {
				if(!q.isEmpty()) {
					q.add(null);
					System.out.println();
				}
			}
			else {
				System.out.print(tmp.data+" ");
				
				if(tmp.left != null) q.add(tmp.left);
				if(tmp.right != null) q.add(tmp.right);
				
					
			}
			
		}
		
	}

}
