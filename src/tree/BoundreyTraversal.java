package tree;

public class BoundreyTraversal {
    static Node tree;
    // 20 8 4 10 14 25 22

    public static void main(String args[]) {
        //Node tree = new Node();
        tree = new Node(20);
        tree.left = new Node(8);
        tree.left.left = new Node(4);
        tree.left.right = new Node(12);
        tree.left.right.left = new Node(10);
        tree.left.right.right = new Node(14);
        tree.right = new Node(22);
        tree.right.right = new Node(25);
        printBoundary(tree);
    }

    private static void printBoundary(Node tree) {

        if (tree == null) return;

        System.out.print(tree.n + " ");

        // top down
        printLeftBoundary(tree.left);

        printleafNodes(tree.left);
        printleafNodes(tree.right);

        // Bottom up
        printRightBoundary(tree.right);
    }

    private static void printRightBoundary(Node tree) {
        if (tree == null) return;

        if (tree.right != null) {
            printRightBoundary(tree.right);
            System.out.print(tree.n + " ");
        } else if (tree.left != null) {
            printRightBoundary(tree.left);
            System.out.print(tree.n);

        }
    }

    private static void printleafNodes(Node tree) {
        if (tree == null) return;

        printleafNodes(tree.left);
        if (tree.right == null && tree.left == null) System.out.print(tree.n + " ");
        printleafNodes(tree.right);

    }

    private static void printLeftBoundary(Node tree) {
        if (tree == null) return;


        if (tree.left != null) {
            System.out.print(tree.n + " ");
            printLeftBoundary(tree.left);
        } else if (tree.right != null) {
            System.out.print(tree.n + " ");
            printLeftBoundary(tree.right);
        }

    }

    /*
    void printLeaves(Node node)
    {
        if (node == null)
            return;

        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node)
    {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

     */
}
