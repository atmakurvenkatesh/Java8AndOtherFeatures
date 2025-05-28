package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelViewOfBinaryTree {

	Node root;

	public LevelViewOfBinaryTree() {
		root = null;
	}

	static void printLevelView(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		List<List<Integer>> sol = new ArrayList<List<Integer>>();
		while (!queue.isEmpty()) {
			List<Integer> l = new ArrayList<Integer>();
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				l.add(queue.peek().data);
				Node node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			sol.add(l);
		}
		System.out.println(sol);
	}

	static void printLevelViewRec(Node root, int level, List<List<Integer>> arr) {
		if (root == null) {
			return;
		}
		if (arr.size() < level + 1) {
			arr.add(new ArrayList<Integer>());
		}
//		System.out.println(root.data + " " + arr);
		arr.get(level).add(root.data);
		printLevelViewRec(root.left, level + 1, arr);
		printLevelViewRec(root.right, level + 1, arr);
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(8);
		root.right.right = new Node(15);
		root.right.left = new Node(12);
		root.left.right.left = new Node(18);
		root.right.right.left = new Node(14);

		printLevelView(root);
		List<List<Integer>> sol = new ArrayList<>();
		printLevelViewRec(root, 0, sol);
		System.out.println(sol);
	}
}
