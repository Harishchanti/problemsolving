package linkedlist;

import java.util.Arrays;
import java.util.List;

public class PalindromeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = null;
		List<String> a = Arrays.asList("a", "b", "c", "c", "b", "a", "l");
		head = create(a);
		print(head);

		System.out.println(isPalindrom(head));

	}

	private static boolean isPalindrom(Node head) {
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node mid = reverse(slow);

		while (mid != null && head != null) {
			if (!(mid.x.equals(head.x))) {
				return false;
			}
			mid = mid.next;
			head = head.next;
		}

		return true;
	}

	private static Node reverse(Node head) {
		Node prev = null;
		Node post = null;

		while (head != null) {
			post = head.next;
			head.next = prev;
			prev = head;
			head = post;
		}

		return prev;
	}

	private static Node create(List<String> a) {
		Node head = null;
		for (String s : a) {
			Node tem = new Node(s);
			if (head == null) {
				head = tem;
			} else {
				Node tempHead = head;
				while (tempHead.next != null) {
					tempHead = tempHead.next;
				}
				tempHead.next = tem;
			}
		}

		return head;
	}

	private static void print(Node head) {
		while (head != null) {
			System.out.print(head.x + " ");
			head = head.next;
		}
		System.out.println();
	}

}
