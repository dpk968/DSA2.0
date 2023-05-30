package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBalacedTree {

	public static void main(String[] args) {
		
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		
		root.left.left.right = new Node(7);
		
		root.left.left.right.left = new Node(8);
		
//		levelOrder(root);
		
//		System.out.println(getHeightUsingLevelOreder(root));
		System.out.println("Balanced->"+isBalanced(root));
		

	}
	
	public static boolean isBalanced(Node root) {

		if(root == null || (root.left == null && root.right == null)) return true;
		
	
		int lh = getHeightUsingLevelOreder(root.left);
		int rh = getHeightUsingLevelOreder(root.right);
		
		
		if(Math.abs(lh - rh)  > 1) return false;
		
		return isBalanced(root.left) && isBalanced(root.right);
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
		System.out.println();
		
	}
	
	
	public static int getHeightUsingLevelOreder(Node root) {
		int h = 0;
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(root);
		q.add(null);
		
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp == null) {
				if(!q.isEmpty()) {
					q.add(null);
				}
				h++;
			}
			else {
				if(tmp.left != null) q.add(tmp.left);
				if(tmp.right != null) q.add(tmp.right);
				
			}
			
			
		}
		return h;

	}

}
