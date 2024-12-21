package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);

		root.left.right.left = new Node(7);
		root.right.left.right = new Node(8);


		verticalOrderTraversal(root);

	}

	private static void verticalOrderTraversal(Node root) {
		
		if (root == null)
			return;

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		Queue<Pair<Node, Integer>> q = new LinkedList<>();

		q.add(new Pair<>(root, 0));

		while (!q.isEmpty()) {
			
			Pair<Node, Integer> tmp = q.poll();
			List<Integer> c;
			
			c = map.containsKey(tmp.second)?map.get(tmp.second):new ArrayList<>();

			c.add(tmp.first.data);
			map.put(tmp.second, c);
			
			if(tmp.first.left != null)
				q.add(new Pair<>(tmp.first.left,tmp.second-1));
			if(tmp.first.right != null)
				q.add(new Pair<>(tmp.first.right,tmp.second+1));

		}
		
		System.out.println(map);

	}

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

	}

}
