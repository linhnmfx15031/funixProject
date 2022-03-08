package asm2;

public class MyStack<T> {
	Node<T> head;
	int size = 0;

	public MyStack() {
		head = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {
		head = null;
	}

	/* push */
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.next = head;
		head = newNode;
		size++;
	}

	/* pop */
	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			T x = head.info;
			head = head.next;
			size--;
			return x;
		}
	}
	
	/* display */
	public void display() {
		if (isEmpty()) {
			System.out.println("List is empty!");
		} else {
			Node<T> t = head;
			while (t != null) {
				System.out.println(t.info);
				t = t.next;
			}
		}
	}
}