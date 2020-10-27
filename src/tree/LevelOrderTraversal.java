package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    private static Node tree_level;

    public static void main(String args[]) {
        /* creating a binary tree and entering
         the nodes */
        tree_level = new Node(1);
        tree_level.left = new Node(2);
        tree_level.right = new Node(3);
        tree_level.left.left = new Node(4);
        tree_level.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        printLevelOrder();
    }

    static void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree_level);
        while (!queue.isEmpty()) {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.n + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
