package tree;

import java.util.*;
import java.util.stream.Collectors;

public class SerializeAndDeSerializeTree {
    public static void main(String[] args) {
        TNode tree = new TNode(20);
        tree.left = new TNode(8);
        tree.left.left = new TNode(4);
        tree.left.right = new TNode(12);
        tree.left.right.left = new TNode(10);
        tree.left.right.right = new TNode(14);
        tree.right = new TNode(22);
        tree.right.right = new TNode(25);
        Codec codec = new Codec();

        System.out.print("Original Tree  :   ");
        printPerOrder(tree);
        System.out.println();

        String serializedString = codec.serialize(tree);
        System.out.println("serializedString : " + serializedString);
        TNode root = codec.deserialize(serializedString);

        System.out.print("Deserialize Tree : ");
        printPerOrder(root);
        int[] aa = {1,2,4};
        //List<Integer> l =Arrays.asList(aa);
        Set<Integer> s = Arrays.stream(aa).boxed().collect(Collectors.toSet());

        Integer[] aaa = {1,2,4};
        Set<Integer> sa = Arrays.stream(aaa).collect(Collectors.toSet());

    }

    private static void printPerOrder(TNode tree) {
        if (tree == null) {
            System.out.print("N,");
        } else {
            System.out.print(tree.val + ",");
            printPerOrder(tree.left);
            printPerOrder(tree.right);
        }
    }
}

class TNode {
    int val;
    TNode left;
    TNode right;

    TNode(int val) {
        this.val = val;
    }

    TNode(int val, TNode left, TNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Codec {
    String n = "N", comma = ",";

    public String serialize(TNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        //sb.setLength(sb.length()-1);
        return sb.toString();
    }

    void serialize(TNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(n).append(comma).toString();
            return;
        }
        sb.append(root.val).append(comma);
        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    public TNode deserialize(String data) {
        Queue<String> queue =
                new LinkedList<>(Arrays.asList(data.split(comma)));
        //System.out.println(queue);
        return deserialize(queue);
    }

    TNode deserialize(Queue<String> queue) {

        String val = queue.poll();

        if (val.equals(n)) {
            return null;
        } else {
            TNode root = new TNode(Integer.parseInt(val));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
            return root;
        }
    }
}