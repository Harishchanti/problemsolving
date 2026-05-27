package tree;

import java.util.Objects;

public class Node {

	int n;
	Node left;
	Node right;

	public Node(int n) {
		this.n = n;

	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node))
            return false;
        Node node = (Node) o;
        return n == node.n;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(n);
    }
}
