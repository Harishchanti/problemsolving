package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrayList {

	public static void main(String[] args) {
		Node first = new Node(1);
		first.next = new Node(4);
		first.next.next = new Node(5);

		Node second = new Node(2);
		second.next = new Node(3);
		second.next.next = new Node(7);

		Node third = new Node(6);
		third.next = new Node(8);
		third.next.next = new Node(9);
		third.next.next.next = new Node(10);

		List<Node> l = new ArrayList<>();
		l.add(first);
		l.add(second);
		l.add(third);

		// Node output = merg(l);
		Node output = mergeKLists(l);
		print(output);

	}

	private static void print(Node output) {
		while (output != null) {
			System.out.print(output.data + " ");
			output = output.next;
		}

	}

	private static Node merg(List<Node> l) {
		PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
			return a.data - b.data;
		});

		for (Node n : l) {
			queue.add(n);
		}
		Node head = null;
		Node min = null;
		while (!queue.isEmpty()) {
			if (head == null) {
				min = queue.poll();
				head = new Node(min.data);
			} else {
				Node temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				min = queue.poll();
				temp.next = new Node(min.data);
			}
			if (min.next != null) {
				queue.add(min.next);
			}
		}

		return head;
	}

	private static Node mergeKLists(List<Node> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node l1, Node l2) {
				return l1.data - l2.data;
			}
		});
		Node head = new Node(0);
		Node p = head;
		for (Node list : lists) {
			if (list != null)
				queue.offer(list);
		}
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			p.next = n;
			p = p.next;
			if (n.next != null)
				queue.offer(n.next);
		}
		return head.next;
	}

}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}