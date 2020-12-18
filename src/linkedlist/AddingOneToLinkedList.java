package linkedlist;

public class AddingOneToLinkedList {

    public static void main(String[] args) {
        int[] a = {1, 9, 9};
        ListNode head = createList(a);
        print(head);
        System.out.println("\n after adding 1 ");
        head = addOne(head);
        //print(head);

        int[] l1 = {1, 3, 5,7,9,11};
        int[] l2 = {2, 4, 6,8,10};

        ListNode list1 = createList(l1);
        ListNode list2 = createList(l2);

        ListNode t = mergeLinkedList(list1,list2);
        print(t);
    }

    static  ListNode mergeLinkedList(ListNode first,ListNode second) {

        ListNode p1 = first, p1_next = null;
        ListNode p2 = second, p2_next = null;

        int i = 0;
        ListNode result = null;
        ListNode end = null;
        while(p1 != null || p2 != null) {

            if(i%2 == 0) {
                if(result == null) {
                    result = p1;
                    end = p1;
                    p1 = p1.next;
                } else {
                    end.next = p1;
                    end = p1;
                    p1 = p1.next;
                }

            } else {

                if(result == null) {
                    result = p2;
                    p2 = p2.next;
                } else {
                    end.next = p2;
                    end = p2;
                    p2 = p2.next;

                }
            }
            i++;
        }

        if(p1 == null) {

            while(p2 != null) {
                end.next = p2;
                end = p2;
                p2 = p2.next;

            }
        } else if(p2 == null) {

            while(p1 != null) {
                end.next = p1;
                end = p1;
                p1 = p1.next;
            }
        }

        return result;
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
