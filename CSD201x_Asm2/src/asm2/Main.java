package asm2;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("---------------------------------------");
		System.out.println("Choose one of this options:");
		System.out.println("Product list:");
		System.out.println("1. Load data from file and display");
		System.out.println("2. Input & add to the end");
		System.out.println("3. Display data");
		System.out.println("4. Save product list to file");
		System.out.println("5. Search by ID");
		System.out.println("6. Delete by ID");
		System.out.println("7. Sort by ID");
		System.out.println("8. Convert to Binary");
		System.out.println("9. Load to stack and display");
		System.out.println("10. Load to queue and display");
		System.out.println("0. Exit");
		System.out.print("Choice: ");
	}

	public static void main(String[] args) {
		OperationToProduct otp = new OperationToProduct();
		MyList<Product> list = new MyList<>();
		MyStack<Product> stack = new MyStack<>();
		MyQueue<Product> queue = new MyQueue<>();

		int choice;
		do {
			showMenu();
			choice = sc.nextInt();
			System.out.println("---------------------------------------");
			switch (choice) {
			case 1:
				otp.getAllItemsFromFile("Data.txt", list);
				break;
			case 2:
				otp.addLast(list);
				break;
			case 3:
				otp.displayAll(list);
				break;
			case 4:
				otp.writeAllItemsToFile("Data.txt", list);
				break;
			case 5:
				otp.searchByCode(list);
				break;
			case 6:
				otp.deleteByCode(list);
				break;
			case 7:
				otp.sortByCode(list);
				System.out.println("Successfully!");
				break;
			case 8:
				System.out.print("Quantity => (");
				otp.convertToBinary(list.head.info.getQuantity());
				System.out.println(")");
				break;
			case 9:
				otp.getAllItemsFromFile("Data.txt", stack);
				break;
			case 10:
				otp.getAllItemsFromFile("Data.txt", queue);
				break;
			case 0:
				System.out.println("Thank you!!!");
				break;

			default:
				System.out.println("Invalid choice. Try again!");
			}

		} while (choice != 0);
	}
}
