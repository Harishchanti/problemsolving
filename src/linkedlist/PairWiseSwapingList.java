package linkedlist;

public class PairWiseSwapingList extends LinkedListProblems {
    public static void main(String[] arg) {
        Node head = new Node("a");
        head.next = new Node("b");
        head.next.next = new Node("c");
        head.next.next.next = new Node("d");
        head.next.next.next.next = new Node("e");
        head.next.next.next.next.next = new Node("f");
        print(head);
        head = pairizeSwap(head);
        print(head);
    }

    private static Node pairizeSwap(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head.next;
        Node pre = head;
        Node result = curr;

        while (true) {
            Node tem = curr.next;
            curr.next = pre;
            if (tem == null || tem.next == null) {
                pre.next = tem;
                break;
            }
            pre.next = tem.next;
            pre = tem;
            curr = pre.next;
        }
        return result;
    }
}
