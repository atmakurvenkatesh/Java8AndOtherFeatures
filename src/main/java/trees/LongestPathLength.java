package trees;

public class LongestPathLength {

	static int inc = 0;
	Node root;

	public LongestPathLength() {
		root = null;
	}

	static int max = 0;

	private static int printLongestPathLength(Node node) {
		inc += 1;
		if (node.left == null && node.right == null) {
			System.out.println(node.data + "end node");
			return 0;
		}
		int ld = 0;
		int rd = 0;
		if (node.left != null) {
			ld = 1 + printLongestPathLength(node.left);
		}
		if (node.right != null) {
			rd = 1 + printLongestPathLength(node.right);
		}
		if ((ld + rd) > max) {
			max = ld + rd;
		}
		System.out.println(node.data + ":" + ld + " " + rd);
		return Math.max(ld, rd);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.right = new Node(9);
		root.right.right = new Node(10);
		root.right.right.right = new Node(11);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
//		root.left.right.right = new Node(8);
//		root.left.left.left = new Node(4);
//		root.left.left.left.left = new Node(5);
//		root.left.left.left.right = new Node(6);
		printLongestPathLength(root);
		System.out.println(max);
		System.out.println(inc);
	}

}
