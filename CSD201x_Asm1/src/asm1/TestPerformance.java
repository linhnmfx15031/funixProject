package asm1;

import java.util.Arrays;

public class TestPerformance {
	double[] arr;

	public TestPerformance(double[] b) {
		arr = b.clone();
	}

	/* Decreasement sort */
	public void decreasementSort(double[] b) {
		int x = b.length;
		for (int i = 0; i < x; i++) {
			double cur = b[i];
			int j = i - 1;
			while (j >= 0 && b[j] < cur) {
				b[j + 1] = b[j];
				j--;
			}
			b[j + 1] = cur;
		}
	}

	/* Increasement sort */
	public void increasementSort(double[] b) {
		int x = b.length;
		for (int i = 0; i < x; i++) {
			double cur = b[i];
			int j = i - 1;
			while (j >= 0 && b[j] > cur) {
				b[j + 1] = b[j];
				j--;
			}
			b[j + 1] = cur;
		}
	}

	/* Swap */
	public void swap(double[] b, int x, int y) {
		double t = b[x];
		b[x] = b[y];
		b[y] = t;
	}

	/* Bubble sort */
	public void bubbleSort(double[] b) {
		double[] c = b.clone();
		int x = c.length;
		System.out.println("Bubble sort");
//		System.out.println("Input: " + Arrays.toString(c));
		long startTime = System.nanoTime();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x - i - 1; j++) {
				if (c[j] > c[j + 1]) {
					swap(c, j, j + 1);
				}
			}
		}
		long endTime = System.nanoTime();
		long total = endTime - startTime;
//		System.out.println("Output: " + Arrays.toString(c));
		System.out.println("Runing time: " + total + " ns");
		System.out.println("--------------------------------------------------");
	}

	/* Selection sort */
	public void selectionSort(double[] b) {
		double[] c = b.clone();
		int x = c.length;
		System.out.println("Selection sort");
//		System.out.println("Input: " + Arrays.toString(c));
		long startTime = System.nanoTime();
		for (int i = 0; i < x - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < x; j++) {
				if (c[minIndex] > c[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(c, i, minIndex);
			}
		}
		long endTime = System.nanoTime();
		long total = endTime - startTime;
//		System.out.println("Output: " + Arrays.toString(c));
		System.out.println("Runing time: " + total + " ns");
		System.out.println("--------------------------------------------------");
	}

	/* Insertion sort */
	public void insertionSort(double[] b) {
		double[] c = b.clone();
		int x = c.length;
		System.out.println("Insertion sort");
//		System.out.println("Input: " + Arrays.toString(c));
		long startTime = System.nanoTime();
		for (int i = 0; i < x; i++) {
			double cur = c[i];
			int j = i - 1;
			while (j >= 0 && c[j] > cur) {
				c[j + 1] = c[j];
				j--;
			}
			c[j + 1] = cur;
		}
		long endTime = System.nanoTime();
		long total = endTime - startTime;
//		System.out.println("Output: " + Arrays.toString(c));
		System.out.println("Runing time: " + total + " ns");
		System.out.println("--------------------------------------------------");
	}

	/* Random sorted */
	public void randomSorted() {
		bubbleSort(arr);
		selectionSort(arr);
		insertionSort(arr);
	}

	/* Increasement sorted */
	public void increasementSorted() {
		double[] c = arr.clone();
		increasementSort(c);
		bubbleSort(c);
		selectionSort(c);
		insertionSort(c);
	}

	/* Decreasement sorted */
	public void decreasementSorted() {
		double[] c = arr.clone();
		decreasementSort(c);
		bubbleSort(c);
		selectionSort(c);
		insertionSort(c);
	}
}
