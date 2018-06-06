package tree;

import java.util.HashMap;
import java.util.Vector;

public class DiagnalViewOfTree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		// Tree t = new Tree(root);

	}

	static void diagonalPrintUtil(Node root, int d, HashMap<Integer, Vector<Integer>> diagonalPrint) {

		// Base case
		if (root == null)
			return;

		// get the list at the particular d value
		Vector<Integer> k = diagonalPrint.get(d);

		// k is null then create a vector and store the data
		if (k == null) {
			k = new Vector<>();
			k.add(root.data);
		}

		// k is not null then update the list
		else {
			k.add(root.data);
		}

		// Store all nodes of same line together as a vector
		diagonalPrint.put(d, k);

		// Increase the vertical distance if left child
		diagonalPrintUtil(root.left, d + 1, diagonalPrint);

		// Vertical distance remains same for right child
		diagonalPrintUtil(root.right, d, diagonalPrint);
	}

}