package trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopBottomViewsOfBinaryTree {

	Node root;

	TopBottomViewsOfBinaryTree() {
		root = null;
	}

	private static void printTopView(Node root) {

		record QueueObj(int hd, Node node) {
		}

		Queue<QueueObj> queue = new LinkedList<>();
		Map<Integer, Node> topViewMap = new TreeMap<>();
		Map<Integer, Node> bottomViewMap = new TreeMap<>();

		if (root == null) {
			return;
		} else {
			queue.add(new QueueObj(0, root));
		}

		while (!queue.isEmpty()) {
			QueueObj obj = queue.poll();

			// printing top view
			if (!topViewMap.containsKey(obj.hd)) {
				topViewMap.put(obj.hd, obj.node);
			}
			// printing bottom view
			bottomViewMap.put(obj.hd, obj.node);

			if (obj.node.left != null) {
				queue.add(new QueueObj(obj.hd - 1, obj.node.left));
			}
			if (obj.node.right != null) {
				queue.add(new QueueObj(obj.hd + 1, obj.node.right));
			}
		}
		for (Integer i : topViewMap.keySet()) {
			System.out.print(topViewMap.get(i).getData() + " ");
		}
//		System.out.println();
//		topViewMap.forEach((key, value) -> System.out.print(value.data + " "));
//		System.out.println();
//		topViewMap.values().stream().map(i -> i.getData()).forEach(System.out::println);
		;
	}

	public static void main(String[] args) {
		TopBottomViewsOfBinaryTree tree = new TopBottomViewsOfBinaryTree();
//		tree.root = new Node(1);
//		tree.root.left = new Node(2);
//		tree.root.right = new Node(3);
//		tree.root.left.right = new Node(4);
//		tree.root.left.right.right = new Node(5);
//		tree.root.left.right.right.right = new Node(6);

		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		tree.root = root;

		printTopView(tree.root);

	}
}
