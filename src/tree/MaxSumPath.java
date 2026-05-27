package tree;

/*
Given the root of a non-empty binary tree, return the maximum path sum of any non-empty path.

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes has an edge connecting them. A node can not appear in the sequence more than once. The path does not necessarily need to include the root.

The path sum of a path is the sum of the node's values in the path.
 */

// Leetcode hard
public class MaxSumPath {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        /*
        Input: root = [-15,10,20,null,null,15,5,-5]

Output: 40

        -15
        /   \
       10     20
             /  \
            15   5
           /
         -5

 = 40

         */
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.left = new TreeNode(-5);
        root.right.right = new TreeNode(5);

        int[] result ={Integer.MIN_VALUE};
        solveMaxPath(root,result);
        System.out.println(result[0]);
    }

    private static int solveMaxPath(TreeNode root, int[] result) {

        if(root == null ){
            return 0;
        }

        int l = solveMaxPath(root.left,result);
        int r = solveMaxPath(root.right,result);

        int a =  l + r + root.val;

        int b = Math.max(l,r) + root.val;

        int c = root.val;

        result[0] = Math.max(result[0],Math.max(a,Math.max(b,c)));

        return Math.max(b,c);

    }
}
