package tree;

import static java.lang.Math.max;

public class LongestBST {

    public static void main(String[] args) {
        /* Let us construct the following Tree
                50
             /      \
            10        60
           /  \       /  \
          5   20    55    70
         /     /  \
        45   65    80
         */

        Node root = new Node(50);
        //root = new Node(50);
        root.left = new Node(10);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(55);
        root.right.left.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        /* The complete tree is not BST as 45 is in right subtree of 50.
         The following subtree is the largest BST
             60
            /  \
          55    70
          /     /  \
        45     65   80
        */
        System.out.println("Size of largest BST is " + largestBST(root));
    }


    static int largestBST(Node root) {
        if (isBST(root))
            return size(root);
        else
            return max(largestBST(root.left), largestBST(root.right));
    }

    private static int size(Node root) {

        if (root == null) return 0;

        else {
            int lHight = size(root.left);
            int rHight = size(root.right);

            if (lHight > rHight) return lHight + 1;

            else return rHight + 1;
        }
    }

    static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    /* Returns true if the given tree is a BST and its 
      values are >= min and <= max. */
    static boolean isBSTUtil(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.n < min || node.n > max)
            return false; 
  
        /* otherwise check the subtrees recursively 
        tightening the min/max constraints */
        // Allow only distinct values 
        return (isBSTUtil(node.left, min, node.n) &&
                isBSTUtil(node.right, node.n, max));
    }
}
