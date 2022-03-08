package asm1;

import java.util.Random;
import java.util.Scanner;

public class MainSort {
	static double[] a;
	static Scanner sc = new Scanner(System.in);

	/* Main */
	public static void main(String[] args) {
		Algorithm algorithm = new Algorithm();
		int choose;
		do {
			menu();
			choose = sc.nextInt();
			System.out.println();

			switch (choose) {
			case 1:
				algorithm.writeFile("INPUT.TXT");
				a = new double[algorithm.n];
				break;
			case 2:
				System.out.println("Read from file");
				algorithm.readFile("INPUT.TXT", a);
				break;
			case 3:
				System.out.println("Bubble Sort");
				algorithm.bubbleSort(a, "OUTPUT1.TXT");
				break;
			case 4:
				System.out.println("Selection Sort");
				algorithm.selectionSort(a, "OUTPUT2.TXT");
				break;
			case 5:
				System.out.println("Insertion Sort");
				algorithm.insertionSort(a, "OUTPUT3.TXT");
				break;
			case 6:
				System.out.println("Search >= value");
				System.out.print("Input value: ");
				double val = sc.nextDouble();
				algorithm.sequentialSearch(a, val);
				break;
			case 7:
				System.err.println("Binary search");
				System.out.print("Input value: ");
				double val2 = sc.nextDouble();
				System.out.println("Index of fist element: "+ algorithm.binarySearch(a, val2));
				System.out.println();
				break;
			case 8:
				System.out.println("Test performance");
				performanceMenu();
				break;
			case 0:
				System.out.println("Thanks!!!");
				break;
			default:
				System.out.println("You didn't select the correct function. Please try again!");
			}
		} while (choose != 0);
	}

	/* Menu */
	public static void menu() {
		System.out.println("+---------Menu---------+");
		System.out.println("| 1. Input             |");
		System.out.println("| 2. Out               |");
		System.out.println("| 3. Bubble sort       |");
		System.out.println("| 4. Selection sort    |");
		System.out.println("| 5. Insertion sort    |");
		System.out.println("| 6. Search >= value   |");
		System.out.println("| 7. Search = value    |");
		System.out.println("| 8. Test performance  |");
		System.out.println("| 9. Exit              |");
		System.out.println("+----------------------+");
		System.out.print("Choose: ");
	}
	
	/* Test performance */
	public static void performanceMenu() {
		double[] arr = new double[2000];
		Random rd = new Random();
		for(int i=0;i<2000;i++) {
			arr[i]= rd.nextInt(2001);
		}
		TestPerformance test=new TestPerformance(arr);
		int choose;
		do {
			System.out.println("1. Random sorted");
			System.out.println("2. Increasement sorted");
			System.out.println("3. Decreasement sorted");
			System.out.println("4. Back");
			System.out.print("Choose: ");
			choose = sc.nextInt();
			System.out.println();
			
			switch (choose) {
			case 1:
				System.out.println("Random sorted");
				test.randomSorted();
				break;
			case 2:
				System.out.println("Increasement sorted");
				test.increasementSorted();
				break;
			case 3:
				System.out.println("Decreasement sorted");
				test.decreasementSorted();
				break;
			case 4:
				System.out.println("Finished!");
				break;
			default:
				System.out.println("Chưa chọn đúng chức năng vui lòng chọn lại!");
			}

		} while (choose != 4);
		System.out.println("--------------------------------------------------");
	}
}
