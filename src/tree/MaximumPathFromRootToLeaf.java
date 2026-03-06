package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaximumPathFromRootToLeaf {
     /*

          0
        /    \
       1       2
     /  \     /  \
    3    4    21   6
   /    /  \
  7    18    9


==> 0 + 1+ 3+ 7 = 11
==> 0 + 1+ 4+ 9 = 14


     */


    public static void main(String[] args) {
        Node root = getNode(0);
        root.left = getNode(1);
        root.left.left = getNode(3);
        root.left.left.left = getNode(7);
        root.left.right = getNode(4);
        root.left.right.left = getNode(18);
        root.left.right.right = getNode(9);
        root.right = getNode(2);
        root.right.left = getNode(21);
        root.right.right = getNode(6);

        int node1 = 4;
        int node2 = 7;

        System.out.println(maximumPathFromRootToLeaf(root));

        List<List<Integer>> path = maxPath(root);
        for(List<Integer> s:path) {
            for(Integer f:s) {
                System.out.print(f + " ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> maxPath(Node root) {

        List<List<Integer>>  result = new ArrayList<List<Integer>>();
        findAllPath(root,23,0,result,new LinkedList<>());
        return result;
    }
    private static  void findAllPath(Node root,int targetSum,int sum,List<List<Integer>> result, List<Integer> temp) {


        if(root == null) return ;

        sum+=root.n;
        temp.add(root.n);
        if(root.left == null && root.right == null && targetSum == sum) {
            result.add(new ArrayList<>(temp));
        }

        findAllPath(root.left,targetSum,sum,result,temp);
        findAllPath(root.right,targetSum,sum,result,temp);
        temp.remove(temp.size()-1);
    }
    private static int maximumPathFromRootToLeaf(Node root) {
        int[] resut = {0};
        getMaximumSum(root,0,resut);
        return resut[0];

    }

    private static void getMaximumSum(Node root,int  sum,int[] resut) {
        if(root  == null) return;

        sum += root.n;

        if(root.left == null && root.right == null) {
            resut[0] = Math.max(resut[0],sum);
        }

        getMaximumSum(root.left,sum,resut);
        getMaximumSum(root.right,sum,resut);
    }

    private static Node getNode(int i) {
        return new Node(i);
    }
}
