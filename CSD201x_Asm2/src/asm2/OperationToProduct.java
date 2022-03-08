package asm2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class OperationToProduct {
	Scanner input = new Scanner(System.in);

	/* product index */
	public int index(Product p, MyList<Product> list) {
		int count = 0;
		Node<Product> t = list.head;
		while (t != null) {
			count++;
			if (p.equals(t.info)) {
				break;
			}
			t = t.next;
		}
		return count;
	}

	/* Creating and returning a product with info input from keyboard */
	public Product createProduct() {
		Product product = new Product();
		System.out.print("Input new ID: ");
		writeOutput("Input new ID: ");
		String id = input.nextLine();
		writeOutput(id);
		product.setBcode(id);
		System.out.print("Input Product's Name: ");
		writeOutput("Input Product's Name: ");
		String title = input.nextLine();
		writeOutput(title);
		product.setTitle(title);
		System.out.print("Input Product's quantity: ");
		writeOutput("Input Product's quantity: ");
		int quantity = Integer.parseInt(input.nextLine());
		writeOutput(Integer.toString(quantity));
		product.setQuantity(quantity);
		System.out.print("Input Product's price: ");
		writeOutput("Input Product's price: ");
		double price = Double.parseDouble(input.nextLine());
		writeOutput(Double.toString(price));
		product.setPrice(price);

		return product;
	}

	/* Reading all products from the file and insert them to the list at tail. */
	public void getAllItemsFromFile(String fileName, MyList<Product> list) {
		list.clear();
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			raf.seek(0);

			String line = raf.readLine();
			while (line != null) {
				line = line.replace("|", ",");
				line = line.replace(" ", "");
				String[] x = line.split(",");
				Product product = new Product();
				product.setBcode(x[0]);
				product.setTitle(x[1]);
				product.setQuantity(Integer.parseInt(x[2]));
				product.setPrice(Double.parseDouble(x[3]));

				list.addToTail(product);
				line = raf.readLine();

			}
			displayAll(list);

			System.out.println("\nSuccessfully!");
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Reading all products from the file and insert them to the stack. */
	public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
		stack.clear();
		stack.size = 0;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			raf.seek(0);

			String line = raf.readLine();
			while (line != null) {
				line = line.replace("|", ",");
				line = line.replace(" ", "");
				String[] x = line.split(",");
				Product product = new Product();
				product.setBcode(x[0]);
				product.setTitle(x[1]);
				product.setQuantity(Integer.parseInt(x[2]));
				product.setPrice(Double.parseDouble(x[3]));

				stack.push(product);
				writeOutput(product.toString());
				line = raf.readLine();
			}

			// display
			System.out.println("ID |  Title   | Quantity | price");
			System.out.println("--------------------------------");
			stack.display();

			System.out.println("\nSuccessfully!");
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Reading all products from the file and insert them to the queue. */
	public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
		queue.clear();
		queue.size = 0;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			raf.seek(0);

			String line = raf.readLine();
			while (line != null) {
				line = line.replace("|", ",");
				line = line.replace(" ", "");
				String[] x = line.split(",");
				Product product = new Product();
				product.setBcode(x[0]);
				product.setTitle(x[1]);
				product.setQuantity(Integer.parseInt(x[2]));
				product.setPrice(Double.parseDouble(x[3]));

				queue.addToHead(product);
				writeOutput(product.toString());
				line = raf.readLine();
			}

			// display
			System.out.println("ID |  Title   | Quantity | price");
			System.out.println("--------------------------------");
			Product[] a = new Product[queue.size];
			Node<Product> t = queue.head;
			int i = 0;
			while (t != null) {
				a[i] = t.info;
				i++;
				t = t.next;
			}
			for (int j = queue.size - 1; j >= 0; j--) {
				System.out.println(a[j]);
			}

			System.out.println("\nSuccessfully!");
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Writing all products from the list to the file */
	public void writeAllItemsToFile(String fileName, MyList<Product> list) {

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			Node<Product> t = list.head;
			while (t != null) {
				bw.write(t.info.getBcode());
				bw.write(" | ");
				bw.write(t.info.getTitle());
				bw.write(" | ");
				int q = t.info.getQuantity();
				bw.write(Integer.toString(q));
				bw.write(" | ");
				Double p = t.info.getPrice();
				bw.write(p.toString());
				bw.newLine();
				t = t.next;
			}

			bw.close();
			osw.close();
			fos.close();
			System.out.println("Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Adding a product to the list, info of the product input from keyboard. */
	public void addLast(MyList<Product> list) {
		Product newProduct = createProduct();
		list.addToTail(newProduct);
		System.out.println();
	}

	/* Adding new product to head of Linked List. The info input from keyboard. */
	public void addFirst(MyList<Product> list) {
		Product newProduct = createProduct();
		list.addToHead(newProduct);
	}

	/* Printing all products of the list to console screen */
	public void displayAll(MyList<Product> list) {
		list.traverse();
	}

	/* Searching product by ID input from keyboard. */
	public void searchByCode(MyList<Product> list) {
		System.out.print("Input the ID to search: ");
		writeOutput("Input the ID to search: ");
		String key = input.nextLine();
		writeOutput(key);
		Node<Product> t = list.head;
		while (t != null) {
			if (t.info.getBcode().equalsIgnoreCase(key)) {
				list.search(t.info);
				return;
			}
			t = t.next;
		}
		System.out.println("Result: -1");
		writeOutput("Result: -1");
	}

	/* Deleting first product that has the ID input from keyboard from the list. */
	public void deleteByCode(MyList<Product> list) {
		System.out.print("Input the bcode to delete: ");
		writeOutput("Input the bcode to delete: ");
		String key = input.nextLine();
		writeOutput(key);
		Node<Product> t = list.head;
		while (t != null) {
			if (t.info.getBcode().equalsIgnoreCase(key)) {
				list.deleteElement(t.info);
				System.out.println("Deleted!");
				writeOutput("Deleted!");
				return;
			}
			t = t.next;
		}
		System.out.println("Result: -1");
		writeOutput("Result: -1");
	}

	/* Deleting the product at position */
	public void deleteAtPosition(MyList<Product> list, int pos) {
		Node<Product> t = list.head;
		int count = 0;
		while (t != null) {
			if (pos == count) {
				list.deleteElement(t.info);
				System.out.println("Deleted!");
				return;
			}
			count++;
			t = t.next;
		}
		System.out.println("-1");
	}

	/* Sorting products in a linked list by ID using quicksort */
	public void sortByCode(MyList<Product> list) {
		if (list.head == list.tail) {
			return;
		}

		MyList<Product> l1 = new MyList<>();
		MyList<Product> l2 = new MyList<>();

		Node<Product> k;
		Node<Product> p;
		k = list.head;
		list.head = list.head.next;
		k.next = null;

		while (list.head != null) {
			p = list.head;
			list.head = list.head.next;
			p.next = null;
			if (p.info.getBcode().compareToIgnoreCase(k.info.getBcode()) <= 0) {
				l1.addToHead(p.info);
			} else {
				l2.addToHead(p.info);
			}
		}

		sortByCode(l1);
		sortByCode(l2);

		if (l1.head != null) {
			list.head = l1.head;
			l1.tail.next = k;
		} else {
			list.head = k;
		}

		if (l2.head != null) {
			k.next = l2.head;
			list.tail = l2.tail;
		} else {
			list.tail = k;
		}
	}

	/* Convert a decimal to an array of binary. */
	public void convertToBinary(int i) {
		int x;
		if (i <= 1) {
			System.out.print(i);
			return;
		}

		x = i % 2;
		i /= 2;
		convertToBinary(i);
		System.out.print(x);
	}

	/* write output */
	public void writeOutput(String s) {

		try {
			File file = new File("console_output.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println();
			pw.print(s);

			pw.close();
			fw.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
