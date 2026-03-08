package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

https://leetcode.com/discuss/post/125080/linkedin-generate-a-binary-tree-from-par-zx4r/


Given the following relationships:

Child Parent IsLeft
15 20 true
19 80 true
17 20 false
16 80 false
80 50 false
50 null false
20 50 true

You should return the following tree:

    50
   /  \
  20   80
 / \   / \
15 17 19 16
 */
public class CreateBinaryTreefromParentChildRelation {
    static class Relation {
        int parent;
        int child;
        boolean isLeft;

        public Relation(int child, int parent, boolean isLeft) {
            this.parent = parent;
            this.child = child;
            this.isLeft = isLeft;
        }
    }

    public static void main(String[] args) {
        List<Relation> relationList = new ArrayList<>();
        relationList.add(new Relation(15, 20, true));
        relationList.add(new Relation(19, 80, true));
        relationList.add(new Relation(17, 20, false));
        relationList.add(new Relation(16, 80, false));
        relationList.add(new Relation(80, 50, false));
        relationList.add(new Relation(50, -1, false));
        relationList.add(new Relation(20, 50, true));

        tree.Node root = constructATree(relationList);
        printTree(root);
    }

    private static Node constructATree(List<Relation> relationList) {
        Node root = null;
        Map<Integer,Integer> parentChildMap = new HashMap<>();
        Map<Integer,Node> nodesMap = new HashMap<>();
        Map<Integer,Boolean> isLeftMap = new HashMap<>();

        for(Relation relation: relationList) {
            nodesMap.put(relation.child, new Node(relation.child));
            parentChildMap.put(relation.child,relation.parent);
        }

        for(Relation relation :relationList) {
            int child = relation.child;
            int parent = relation.parent;

            Node childNode = nodesMap.get(child);
            Node parentNode= nodesMap.get(parent);

            if(parent == -1) {
                root = childNode;
            } else if (relation.isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

        }

        return root;

    }

    private static void printTree(Node root) {
        if(root != null) {
            printTree(root.left);
            System.out.print(root.n+ " ");
            printTree(root.right);
        }
    }
}
