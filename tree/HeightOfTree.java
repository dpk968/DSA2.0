package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightOfTree {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.err.println("Enter BST data");
		BST tree = new BST();

		int data = sc.nextInt();

		while (data != -1) {
			tree.add(data);
			data = sc.nextInt();
		}

		levelOrder(tree.root);

		System.out.println("\nHeight-> " + getHeight(tree.root));

		sc.close();

		System.out.println(getHeightUsingLevelOreder(tree.root));

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

	private static int getHeight(Node root) {

		if (root == null)
			return 0;

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));

	}

	private static int getHeightUsingLevelOreder(Node root) {
		int h = 0;

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (tmp == null) {
				if (!q.isEmpty()) {
					q.add(null);
				}
				h++;
			} else {
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);

			}

		}
		return h;

	}

}
