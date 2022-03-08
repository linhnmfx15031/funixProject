package asm2;

public class MyList<T> {
	Node<T> head;
	Node<T> tail;

	public MyList() {
		head = tail = null;
	}

	public MyList(Node<T> head, Node<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {
		head = tail = null;
	}

	/* length */
	public int length() {
		int count = 0;
		Node<T> t = head;
		while (t != null) {
			count++;
			t = t.next;
		}
		return count;
	}

	/* add to head */
	public void addToHead(T item) {
		Node<T> newNode = new Node<>(item);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	/* add to tail */
	public void addToTail(T item) {
		Node<T> newNode = new Node<>(item);
		if (isEmpty()) {
			newNode.next = head;
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	/* insert after position */
	public void insertAfterPosition(int position, T item) {
		Node<T> newNode = new Node<>(item);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			Node<T> t = head;
			int count = 0;
			while (t != null) {
				if (count == position) {
					newNode.next = t.next;
					t.next = newNode;
					break;
				}
				t = t.next;
			}
		}
	}

	/* delete at tail */
	public void deleteTail() {
		Node<T> prev = head;
		while (prev.next != null) {
			prev = prev.next;
		}
		prev.next = null;
		tail = prev;
	}

	/* delete element */
	public void deleteElement(T item) {
		Node<T> curr = head;
		Node<T> prev = head;
		if (isEmpty()) {
			System.out.println("List is empty!");
		} else if (head.info.equals(item)) {
			head = head.next;
		} else {
			while (curr.next != null) {
				if (curr.info.equals(item)) {
					break;
				}
				prev = curr;
				curr = curr.next;
			}
			prev.next = curr.next;
			if (prev.next == null) {
				tail = prev;
			}
		}
	}

	/* swap */
	public void swap(Node<T> firstNode, Node<T> secondNode) {
		if (isEmpty()) {
			System.out.println("List is empty!");
		} else {
			Node<T> t = new Node<>();
			t.info = firstNode.info;
			firstNode.info = secondNode.info;
			secondNode.info = t.info;
		}
	}

	/* traverse */
	public void traverse() {
		OperationToProduct otp = new OperationToProduct();
		System.out.println("ID |  Title   | Quantity | price");
		System.out.println("--------------------------------");
		if (isEmpty()) {
			System.out.println("List is empty!");
		} else {
			Node<T> t = head;
			while (t != null) {
				System.out.println(t.info);
				otp.writeOutput(t.info.toString());
				t = t.next;
			}
		}
	}

	/* search */
	public void search(T item) {
		OperationToProduct otp = new OperationToProduct();
		Node<T> t = head;
		while (t != null) {
			if (t.info.equals(item)) {
				break;
			}
			t = t.next;
		}
		System.out.println(t.info);
		otp.writeOutput(t.info.toString());
	}
}
