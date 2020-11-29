package company_interview;

import java.util.ArrayList;
import java.util.List;

public class CashFree {

    /*

               3
             /   \
            /     \
           4       5
           /\      \
          /  \      \
         2    10    20
        /     \
       /       \
      70        80

     [70,80,5]
     */

    public static void main(String[] arg) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(70);
        root.left.right = new TreeNode(10);
        root.left.right.right = new TreeNode(80);
        root.right.right = new TreeNode(20);
        List<TreeNode> outPut = new ArrayList<>();
        getKDistanceNodes(root, root.left, 2, outPut, 0);

        /*outPut.stream().forEach(o -> {
            System.out.print(o.val + " ");
        });*/

        // 2. Find first missing positive element in unsorted array :

        int[] a = {2, 100, 105, 4, -1, -2};

        // a = {2, ,
        //output : 1
        boolean[] b = new boolean[a.length];
        //Arrays.fill(b, false);

        for (int i = 0; i < a.length; i++) {
            if (a[i] >0 && a[i] < a.length)
                b[a[i] - 1] = true;
        }

        for(int i = 0;i<b.length;i++) {
            if(!b[i]) System.out.print(i+1);break;
        }

    }

    static int getKDistanceNodes(TreeNode root, TreeNode pivot, int k, List<TreeNode> outPut, int dis) {
        TreeNode temp = root;
        if (root == null) return -1;

        if (root == pivot) {
            findAllkDistancefromNode(root, k, outPut);
            return 1;
        }

        int left = getKDistanceNodes(root.left, pivot, k, outPut, dis + 1);
        int right = getKDistanceNodes(root.right, pivot, k, outPut, dis + 1);

        if (left != -1) {
            int f = k - dis - 1;
            findAllkDistancefromNode(temp, f, outPut);
            return -1;
        }
        if (right != -1) {
            int f = k - dis - 1;
            findAllkDistancefromNode(temp, f, outPut);
            return -1;
        }

        return -1;
    }

    private static void findAllkDistancefromNode(TreeNode root, int k, List<TreeNode> output) {

        if (root == null) return;

        if (k == 0) output.add(root);

        findAllkDistancefromNode(root.left, k - 1, output);
        findAllkDistancefromNode(root.right, k - 1, output);
    }


}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}


