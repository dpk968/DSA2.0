package tree;

import java.util.*;

public class ZigZag {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		zigZag(root);
		

	}
	
//	public static void 

	private static void zigZag(Node root) {
		
		if(root == null) return;

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		List<Integer> list = new ArrayList<>();
		
		boolean rightToleft = true;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(tmp == null) {
				if(!q.isEmpty()) {
					q.add(null);
				}
				
				int start = rightToleft?0:list.size()-1;
				int end = rightToleft?list.size()-1:0;
				int increment = rightToleft?1:-1;
				
				for(int i=start;i!=end+increment;i+=increment) {
					System.out.print(list.get(i)+" ");
				}
				System.out.println();
				
				rightToleft = !rightToleft;
				
				list = new LinkedList<>();
			}else {
				if(tmp.left != null) 
					q.add(tmp.left);
				if(tmp.right != null)
					q.add(tmp.right);
				list.add(tmp.data);
			}
		}
		
	}


}
