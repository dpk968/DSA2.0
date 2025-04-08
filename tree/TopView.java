package tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

	public static void levelOrder(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();

		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {

			Node tmp = q.poll();
			if (tmp == null) {
				if (!q.isEmpty()) {
					q.add(null);
					System.out.println();
				}
			} else {
				System.out.print(tmp.data + " ");

				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);

			}

		}
		
		System.out.println();

	}

	public static void main(String ards[]) {

		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);

		root.left.left.right = new Node(7);

		root.left.left.right.left = new Node(8);

		levelOrder(root);
		
		System.out.println("top view");
		
		getTopView(root);

	}

	public static void getTopView(Node root) {
		if (root == null)
			return;

		Queue<Pair<Node, Integer>> q = new LinkedList<>();

		TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

		q.add(new Pair<>(root, 0));

		while (!q.isEmpty()) {
			Pair<Node, Integer> p = q.poll();

			if (!sortedMap.containsKey(p.second)) 
				sortedMap.put(p.second, p.first.data);
			
			if (p.first.left != null) 
				q.add(new Pair<>(p.first.left,p.second-1));
			
			if (p.first.right != null) 
				q.add(new Pair<>(p.first.right,p.second+1));
			
		}
		
		System.out.println(sortedMap.values());
	}

}
