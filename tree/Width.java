package tree;


import java.util.LinkedList;
import java.util.Queue;

public class Width {

	public static void main(String[] args) {
		
		System.out.println("Hello ji");
		
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.right.right = new Node(5);

		System.out.println(getWidth(root));
		

	}
	

	private static int getWidth(Node root) {
		
		Queue<Pair<Node,Integer>> q = new LinkedList<>();
		
		q.add(new Pair<>(root,0));
		
		int w=0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			Pair<Node,Integer> first = null,last=null;
			
			for(int i=0;i<size;i++) {
				Pair<Node,Integer> tmp = q.poll();
				
				if(i==0) first = tmp;
				if(i==size-1) last = tmp;
				if(tmp.first.left != null)
					q.add(new Pair<>(tmp.first.left,2*(tmp.second-1)+1));
				if(tmp.first.right != null)
					q.add(new Pair<>(tmp.first.right,2*(tmp.second-1)+2));
				
			}
			w = Math.max(w,last.second - first.second + 1);
		}
		
		return w;
	}

}
