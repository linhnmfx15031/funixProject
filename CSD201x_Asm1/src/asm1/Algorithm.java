package asm1;

import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;

public class Algorithm {
	int n;

	/* Input */
	public int input() {
		System.out.print("Input number of elements: ");
		do {
			n = MainSort.sc.nextInt();
			if (n <= 20 && n > 0) {
				break;
			} else {
				System.out.print("Please try again! (0 < n <= 20) n = ");
			}
		} while (true);
		System.out.println();
		return n;
	}

	/* Ghi dữ liệu vào file */
	public void writeFile(String fileName) {
		input();
		try {
			// Tạo mới file INPUT.TXT
			Random rd = new Random();
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

			int choose;
			do {
				System.out.println("1. Manual input");
				System.out.println("2. Auto input");
				System.out.println("3. Back");
				System.out.print("Choose: ");
				choose = MainSort.sc.nextInt();

				switch (choose) {
				case 1:
					// Nhập dữ liệu từ bàn phím và ghi vào file
					for (int i = 1; i <= n; i++) {
						System.out.print("Number " + i + ": ");
						double num = MainSort.sc.nextDouble();
						raf.writeDouble(num);
					}
					System.out.println("Done!");
					System.out.println();
					break;
				case 2:
					// Nhập dữ liệu dự động và ghi vào file
					for (int i = 1; i <= n; i++) {
						double num = rd.nextInt(100);
						raf.writeDouble(num);
					}
					System.out.println("Done!");
					System.out.println();
					break;
				case 3:
					break;
				default:
					System.out.println("Please try again!");
				}
			} while (choose != 3);

			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	/* Đọc dữ liệu từ file */
	public void readFile(String fileName, double[] arr) {
		try {
			// Tạo mới file INPUT.TXT
			RandomAccessFile raf = new RandomAccessFile(fileName, "r");

			// Đọc dữ liệu và lưu vào mảng a
			raf.seek(0);
			for (int i = 0; i < n; i++) {
				arr[i] = raf.readDouble();
			}

			// In dữ liệu từ mảng a ra màn hình
			System.out.println("Elements of array:");
			System.out.println(Arrays.toString(arr));
			raf.seek(0);
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------");
	}

	/* swap */
	public void swap(double[] arr, int x, int y) {
		double t = arr[x];
		arr[x] = arr[y];
		arr[y] = t;
	}

	// ghi dữ liệu
	public void writeAfterSort(String fileName, double[] arr) {
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			raf.seek(0);
			for (double d : arr) {
				raf.writeDouble(d);
			}
			raf.seek(0);
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Bubble sort */
	public void bubbleSort(double[] arr, String fileName) {
		double[] b = arr.clone();

		// sắp xếp
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (b[j] > b[j + 1]) {
					swap(b, j, j + 1);
				}
			}
			System.out.println(Arrays.toString(b));
		}

		// ghi dữ liệu vào file
		writeAfterSort(fileName, b);
		System.out.println("--------------------------------------------------");
	}

	/* Selection sort */
	public void selectionSort(double[] arr, String fileName) {
		double[] b = arr.clone();

		// sắp xếp
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (b[j] < b[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(b, minIndex, i);
			}
			System.out.println(Arrays.toString(b));
		}

		// ghi dữ liệu vào file
		writeAfterSort(fileName, b);
		System.out.println("--------------------------------------------------");
	}

	/* Insertion sort */
	public void insertionSort(double[] arr, String fileName) {
		double[] b = arr.clone();

		// sắp xếp
		for (int i = 0; i < n; i++) {
			double cur = b[i];
			int j = i - 1;
			while (j >= 0 && b[j] > cur) {
				b[j + 1] = b[j];
				j--;
			}
			b[j + 1] = cur;

			System.out.println(Arrays.toString(b));
		}

		// ghi dữ liệu vào file
		writeAfterSort(fileName, b);
		System.out.println("--------------------------------------------------");
	}

	/* Search >= value */
	public void sequentialSearch(double[] arr, double value) {
		System.out.print("Index: ");
		for (int i = 0; i < n; i++) {
			if (arr[i] >= value) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("--------------------------------------------------");
	}

	/* Search = value */
	public int binarySearch(double[] arr, double value) {
		// sắp xếp
		double[] b = arr.clone();
		for (int i = 0; i < n; i++) {
			double cur = b[i];
			int j = i - 1;
			while (j >= 0 && b[j] > cur) {
				b[j + 1] = b[j];
				j--;
			}
			b[j + 1] = cur;
		}

		// search
		int lower = 0;
		int upper = n - 1;
		int mid = -1;

		if (b[lower] > value || b[upper] < value) {
			return -1;
		}

		while (upper >= lower) {
			mid = lower + (upper - lower) / 2;

			if (b[mid] > value) {
				upper = mid - 1;
			} else if (b[mid] < value) {
				lower = mid + 1;
			} else {
				return mid;
			}
		}
		return mid;
	}
}
