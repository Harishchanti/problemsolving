package tree;

public class PathSum3 {
    public static void main(String[] args) {
        // Create a sample tree:
        //        8
        //      /  \
        //     4    5
        //    / \    \
        //   3   2    2
        //  / \   \
        // 3  -2   1

        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right.right = new Node(2);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);

        int k = 7;

        System.out.println(countAllPaths(root, k));
    }

    static int countPathsFromNode(Node node, int k, int currentSum) {
        if (node == null)
            return 0;

        int pathCount = 0;
        currentSum += node.n;

        if (currentSum == k)
            pathCount++;

        // Recur for the left and right subtree
        pathCount += countPathsFromNode(node.left, k, currentSum);
        pathCount += countPathsFromNode(node.right, k, currentSum);

        return pathCount;
    }

    // Function to count all paths
    // that sum to k in the binary tree
    static int countAllPaths(Node root, int k) {
        if (root == null)
            return 0;

        // Count all paths starting from the current node
        int res = countPathsFromNode(root, k, 0);

        // Recur for the left and right subtree
        res += countAllPaths(root.left, k);
        res += countAllPaths(root.right, k);

        return res;
    }

}
