package asm3;

import java.util.Scanner;

public class Employee extends Staff implements ICalculator {
	private double overTime;

	// constructors
	public Employee() {
	}

	public Employee(double overTime) {
		this.overTime = overTime;
	}

	// getters & setters
	public double getOverTime() {
		return overTime;
	}

	public void setOverTime(double overTime) {
		this.overTime = overTime;
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

		System.out.print("Bộ phận làm việc: ");
		System.out.println("Employee");
		System.out.print("Nhập số giờ làm thêm: ");
		overTime = Double.parseDouble(HumanResources.sc.nextLine());

		setSalary(calculateSalary());
	}

	// toString
	@Override
	public String toString() {
		return "[" + super.toString() + " | Số giờ làm thêm: " + overTime + "]";
	}

	@Override
	public double calculateSalary() {
		return getSalaryCoe() * staffBaseSalary + overTime * overTimeSalary;
	}

}
