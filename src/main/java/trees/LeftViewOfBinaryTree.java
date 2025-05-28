package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

	Node root;

	LeftViewOfBinaryTree(Node root) {
		root = null;
	}

	static int curLevel = 0;

	static void printLeftViewUsingQueue(Node root) {

		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int n = queue.size();
			for (int i = 0; i < n; i++) {
				Node tmp = queue.poll();
				if (i == 0) { // if (i == n - 1) for right view
					System.out.print(tmp.data + " ");
				}
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
			}
		}
	}

	static void printLeftViewUsingRecurssion(Node node, int level) {

		if (node == null) {
			return;
		}

		if (curLevel == level) {
			curLevel += 1;
			System.out.print(node.data + " ");
		}

		printLeftViewUsingRecurssion(node.left, level + 1);
		printLeftViewUsingRecurssion(node.right, level + 1);
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(8);
		root.right.right = new Node(15);
		root.right.left = new Node(12);
		root.right.right.left = new Node(14);

		printLeftViewUsingQueue(root);
		System.out.println();
		printLeftViewUsingRecurssion(root, 0);
	}

}
