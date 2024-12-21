package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.right.right.left = new Node(10);
		root.right.right.right = new Node(11);
		
		bottomView(root);
		

	}

	private static void bottomView(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		
		Queue<Pair<Node, Integer>> q = new LinkedList<>();
		
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		q.add(new Pair<>(root,0));
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				Pair<Node, Integer> tmp  = q.poll();
				
				map.put(tmp.second, tmp.first.data);
				
				if(tmp.first.left != null) {
					q.add(new Pair<>(tmp.first.left,tmp.second-1));
				}
				if(tmp.first.right != null) {
					q.add(new Pair<>(tmp.first.right,tmp.second+1));
				}
				
			}
		}
		
		System.out.println(map.values());
		
		
	}

}
