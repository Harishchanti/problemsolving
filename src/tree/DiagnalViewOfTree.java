package tree;

import java.util.*;

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
    /*
          1
       /    \
      2       3
        \
         4
           \
             5
              \
                6


     */

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        // Tree t = new Tree(root);
      //  inOrderTraversal(root);
        TreeMap<Integer, ArrayList<Integer>> vectorHashMap = new TreeMap<>();
        diagonalPrintUtil(root, 0, vectorHashMap);
        for (Map.Entry<Integer, ArrayList<Integer>> elements : vectorHashMap.entrySet()) {
            ArrayList<Integer> integerArrayList = elements.getValue();
            integerArrayList.forEach(System.out::println);
        }

    }

    private static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }

    static void diagonalPrintUtil(Node root, int d,
            TreeMap<Integer, ArrayList<Integer>> diagonalPrint) {

        // Base case
        if (root == null)
            return;

        // get the list at the particular d value
        ArrayList<Integer> k = diagonalPrint.get(d);

        // k is null then create a vector and store the data
        if (k == null) {
            k = new ArrayList<>();
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