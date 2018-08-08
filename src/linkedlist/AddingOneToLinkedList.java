package linkedlist;

public class AddingOneToLinkedList {

    public static void main(String[] args) {
        int[] a = {1, 9, 9};
        ListNode head = createList(a);
        print(head);
        System.out.println("\n after adding 1 ");
        head = addOne(head);
        print(head);
    }

    private static ListNode addOne(ListNode head) {
        ListNode result = head;
        ListNode firstNine = null;

        while (head.next != null) {
            if (head.next.data == 9 && firstNine == null) {
                firstNine = head;
            } else if (head.next.data < 8) {
                firstNine = null;
            }
            head = head.next;
        }

        if (firstNine == null) {
            if (result.data == 9) {
                ListNode temp1 = new ListNode(1);
                firstNine = result;
                result = temp1;
                temp1.next = firstNine;
            } else {
                head.data = head.data + 1;
                return result;
            }

        }
        if (firstNine == result && firstNine.data == 9) {
            ListNode temp1 = new ListNode(1);
            temp1.next = result;
            result = temp1;
        }

        while (firstNine != null) {
            if (firstNine.data == 9) {
                firstNine.data = 0;
            } else {
                firstNine.data += 1;
            }
            firstNine = firstNine.next;
        }

        return result;
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    private static ListNode createList(int[] a) {
        if (a.length < 0) {
            return null;
        }
        ListNode head = new ListNode(a[0]);
        ListNode temp = head;
        for (int i = 1; i < a.length; i++) {
            ListNode t = new ListNode(a[i]);
            temp.next = t;
            temp = temp.next;
        }
        return head;
    }

}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        super();
        this.data = data;
    }
}
