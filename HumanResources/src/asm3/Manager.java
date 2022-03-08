package asm3;

import java.util.Scanner;

public class Manager extends Staff implements ICalculator {
	private String title;

	// constructors
	public Manager() {

	}

	public Manager(String title) {
		this.title = title;
	}

	// getters & setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// display
	@Override
	public void displayInformation() {
		System.out.println(this);
	}

	// input
	@Override
	public void input() {
		super.input();

		// chọn bộ phận làm việc
		System.out.print("Bộ phận làm việc: ");
		System.out.println("Manager");

		// chọn chức danh
		System.out.println("Chọn chức danh:");
		System.out.println("1. Business Leader");
		System.out.println("2. Project Leader");
		System.out.println("3. Technical Leader");
		System.out.print("Chọn: ");
		int choose;
		do {
			choose = Integer.parseInt(HumanResources.sc.nextLine());
			switch (choose) {
			case 1:
				title = "Business Leader";
				break;
			case 2:
				title = "Project Leader";
				break;
			case 3:
				title = "Technical Leader";
				break;
			default:
				System.out.println("Chưa chọn đúng chức danh!");
			}
		} while (choose != 1 && choose != 2 && choose != 3);

		System.out.println("Chức danh: " + title);

		setSalary(calculateSalary());
	}

	// to string
	@Override
	public String toString() {
		return "[Chức danh: " + title + " | " + super.toString() + "]";
	}

	// Salary
	@Override
	public double calculateSalary() {
		double salary = 0;
		if (title.equals("Business Leader")) {
			salary = getSalaryCoe() * managerBaseSalary + BLRes;
		} else if (title.equals("Project Leader")) {
			salary = getSalaryCoe() * managerBaseSalary + PLRes;
		} else if (title.equals("Technical Leader")) {
			salary = getSalaryCoe() * managerBaseSalary + TLRes;
		}
		return salary;
	}

}
