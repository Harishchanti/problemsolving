package memoryanalyzer;

public class HeapMemoryAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 50000000000;
		char[] s = new char[500000000];

		// String s1 = new String(s);

		// StringBuilder ff = new StringBuilder(s1);
		Node head = new Node(0);
		Integer i = new Integer(1);
		for (int j = 0; j < 10000000; j++) {
			for (; i < 1000000000; i++) {
				Node temp = new Node(i);
				temp.next = head;
				head = temp;
				System.out.println(i);
			}
		}
		// display(head);
	}

	private static void display(Node head) {
		while (head != null) {
			System.out.println(head.i);
			head = head.next;
		}
	}

}

class Node {
	int i;
	Node next;

	Node(int i) {
		this.i = i;
		this.next = null;
	}
}