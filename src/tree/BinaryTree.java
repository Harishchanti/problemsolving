package tree;

public class BinaryTree {
	// static Node root = null;

	public static void main(String[] args) {
		int[] a = new int[] { 2, 45, 12, 3, 4, 22 };
		/*Node root = null;
		for (int i = 0; i < a.length; i++) {

			root = createTree(root, a[i]);
		}*/

		Node root = createrecurseive(a, null, 0);

		print(root);// 3 45 4 2 22 12
					// 45 2 3 12 22 4
					// 4 22 12 3 2 45
	}

	private static Node createrecurseive(int[] a, Node root, int i) {

		if (i < a.length) {
			root = new Node(a[i]);

			root.left = createrecurseive(a, root.left, (2 * i + 1));
			root.right = createrecurseive(a, root.right, (2 * i + 2));
		}

		return root;
	}

	private static void print(Node head) {
		if (head != null) {
			print(head.left);
			System.out.print(head.n + " ");
			print(head.right);
		}

	}

	private static Node createTree(Node root, int a) {

		if (root == null) {
			root = new Node(a);

		} else {
			if (root.right == null) {
				root.right = createTree(root.right, a);
			} else {
				root.left = createTree(root.left, a);
			}
		}

		return root;

	}

}
