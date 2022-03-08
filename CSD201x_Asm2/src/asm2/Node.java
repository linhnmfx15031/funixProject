package asm2;

public class Node<T> {
	T info;
	Node<T> next;

	public Node() {

	}

	public Node(T info, Node<T> next) {
		this.info = info;
		this.next = next;
	}

	public Node(T info) {
		this.info = info;
		next = null;
	}

	@Override
	public String toString() {
		return info.toString();
	}
}
