package tree;

import java.util.*;
/*
Approach
The problem asks us to find all nodes at a certain distance from a given target node in a binary tree. The key insight is to treat the tree as a graph and perform a breadth-first search (BFS) starting from the target, but we need to know the parent of each node.

Here's how the algorithm would work step-by-step:

1. First, transform the binary tree into a graph where each node also knows its parent. This will let us move both up and down the tree during our search.

2. Use a standard breadth-first search algorithm, starting at the target node.

3. Keep track of the distance from the target node as you explore outwards.

4. At each node, check its left child, right child, and parent (if it exists and hasn't been visited yet).

5. Continue the breadth-first search until you reach the desired distance from the target.

6. Collect all the nodes at that distance. These are the nodes that meet the criteria of the question.

The conversion to a graph allows the flexibility to go up and down the tree, and BFS guarantees you find nodes at distance K while visiting the fewest nodes possible.
 */

public class PrintAllTheNodeKDdistenceFromtheTargetNode {
    public static void main(String[] args) {
        // Create a hard coded tree.
        //         20
        //       /    \
        //      7      24
        //    /   \
        //   4     3
        //        /
        //       1
        Node root = new Node(20);
        root.left = new Node(7);
        root.right = new Node(24);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.left.right.left = new Node(1);

        int target = 7, k = 2;
        List<Integer> ans
                = KDistanceNodes(root, target, k);

        ans.forEach(System.out::println);
    }

    private static List<Integer> KDistanceNodes(Node root, int target, int k) {
        Map<Node, Node> chaildParentMap = new HashMap<>();
        Node targetNode = getChaildParentMap(root,  chaildParentMap, target);
        Queue<Node> queue = new LinkedList<>();
        List<Node> visited = new ArrayList<>();

        queue.add(targetNode);
        visited.add(targetNode);
        int dis = 0;
        while (!queue.isEmpty()) {

            int l = queue.size();
            if (dis == k) {
                List<Integer> result = new ArrayList<>();
                for (int i = 0; i < l; i++) {
                    result.add(Objects.requireNonNull(queue.poll()).n);
                }
                return result;
            }

            for (int i = 0; i < l; i++) {

                Node current = queue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                }

                if (chaildParentMap.containsKey(current) && !visited.contains(
                        chaildParentMap.get(current))) {
                    queue.add(chaildParentMap.get(current));
                    visited.add(chaildParentMap.get(current));
                }

            }
            dis++;
        }
        return new ArrayList<>();
    }

    private static Node getChaildParentMap(Node root,
            Map<Node, Node> chaildParentMap, int k) {
        if (root == null) {
            return root;
        }

        Node left = null , right = null;
        if(root.left != null) {
            chaildParentMap.put(root.left, root);
            left = getChaildParentMap(root.left, chaildParentMap, k);
        }

        if(root.right != null) {
            chaildParentMap.put(root.right, root);
            right = getChaildParentMap(root.right, chaildParentMap, k);
        }


        if (root.n == k)
            return root;

        return left != null ? left : right;
    }
}
