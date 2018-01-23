package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedListProblems {
	/*
	 * // M->R P->Z A->X T->M X->T R->P
	 */
	public static void main(String[] arg) {
		Map<String, String> q = new HashMap<String, String>();
		q.put("M", "R");
		q.put("P", "Z");
		q.put("A", "X");
		q.put("T", "M");
		q.put("X", "T");
		q.put("R", "P");

		Node head = correct(q);
		print(head);
	}

	private static void print(Node head) {
		while (head != null) {
			System.out.print(head.x+"->");
			head = head.next;
		}
	}

	private static Node correct(Map<String, String> q) {
		Node head = null;
		Set<String> AllElement = new HashSet<String>();
		List<String> values = new ArrayList<String>();
		for (Entry<String, String> f : q.entrySet()) {
			String value1 = f.getValue();
			AllElement.add(f.getKey());
			//AllElement.add(value1);
			values.add(value1);
		}
		AllElement.removeAll(values);
		String top = null;
		if (AllElement.size() == 1) {
			Iterator<String> iterator = AllElement.iterator();
			top = iterator.next();
		}
		int i = 0;
		if (top != null) {
			head = new Node(top);
			Node last = head;
			while (i <= q.size()) {
				top = q.get(top);
				Node temp = new Node(top);

				last.next = temp;
				last = last.next;
				i++;
			}
		}
		return head;
	}

}

