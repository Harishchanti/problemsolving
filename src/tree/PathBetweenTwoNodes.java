package tree;

import java.util.ArrayList;
import java.util.List;

public class PathBetweenTwoNodes {

    public static void main(String[] args) {
        Node root = getNode(0);
        root.left = getNode(1);
        root.left.left = getNode(3);
        root.left.left.left = getNode(7);
        root.left.right = getNode(4);
        root.left.right.left = getNode(8);
        root.left.right.right = getNode(9);
        root.right = getNode(2);
        root.right.left = getNode(5);
        root.right.right = getNode(6);

        int node1 = 4;
        int node2 = 7;
        printPathBetweenNodes(root, node1, node2);
    }

    private static void printPathBetweenNodes(Node root, int node1, int node2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        getPath(root, node1, path1);
        getPath(root, node2, path2);

        int i = 0, j = 0, intersection = 0;

        while (i < path1.size() || j < path2.size()) {

            if (path1.get(i) == path2.get(j) && i == j) {
                i++;
                j++;
            } else {
                intersection = j - 1;
                break;
            }
        }

        for (int k = path1.size() - 1; k > intersection; k--) {
            System.out.print(path1.get(k) + " -> ");
        }


        for (int k = intersection; k < path2.size(); k++) {
            System.out.print(path2.get(k) + " -> ");
        }

    }

    private static boolean getPath(Node root, int data, List<Integer> pathList) {
        if (root == null) return false;

        pathList.add(root.n);

        if (root.n == data) {
            return true;
        }

        boolean v1 = getPath(root.left, data, pathList);
        boolean v2 = getPath(root.right, data, pathList);

        if (v1 || v2) {
            return true;
        }
        pathList.remove(pathList.size() - 1);
        return false;
    }

    private static Node getNode(int i) {
        return new Node(i);
    }
}
