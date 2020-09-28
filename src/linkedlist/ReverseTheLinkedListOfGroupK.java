package linkedlist;

public class ReverseTheLinkedListOfGroupK extends LinkedListProblems {
    public static void main(String[] arg) {
        Node head = new Node("1");
        head.next = new Node("2");
        head.next.next = new Node("3");
        head.next.next.next = new Node("4");
        head.next.next.next.next = new Node("5");
        head.next.next.next.next.next = new Node("6");
        head.next.next.next.next.next.next = new Node("7");
        head.next.next.next.next.next.next.next = new Node("8");
        head.next.next.next.next.next.next.next.next = new Node("9");

        print(head);
        Node pHead = swapThelistLengthK(head, 2);

        print(pHead);
    }

    private static Node swapThelistLengthK(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.next = swapThelistLengthK(next, k);

        return prev;

    }
}
