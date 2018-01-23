package linkedlist;

public class Node {
	String x;
	Node next;

	Node(String x) {
		this.x = x;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
