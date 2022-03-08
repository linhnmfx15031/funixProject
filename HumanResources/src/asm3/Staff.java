package asm3;

import java.util.Scanner;

public abstract class Staff {
	private String id, name, startDate;
	private int age, dayOff;
	private double salaryCoe, salary;
	private Department department;

	// constructors
	protected Staff() {

	}

	protected Staff(String id, String name, String startDate, Department department, int age, int dayOff, double salaryCoe, double salary) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.department = department;
		this.age = age;
		this.dayOff = dayOff;
		this.salaryCoe = salaryCoe;
		this.salary = salary;
	}

	// getters & setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDayOff() {
		return dayOff;
	}

	public void setDayOff(int dayOff) {
		this.dayOff = dayOff;
	}

	public double getSalaryCoe() {
		return salaryCoe;
	}

	public void setSalaryCoe(double salaryCoe) {
		this.salaryCoe = salaryCoe;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	// display
	public abstract void displayInformation();

	// input
	public void input() {

		System.out.print("Nhập mã nhân viên: ");
		id = HumanResources.sc.nextLine();
		System.out.print("Nhập tên: ");
		name = HumanResources.sc.nextLine();
		System.out.print("Nhập tuổi: ");
		age = Integer.parseInt(HumanResources.sc.nextLine());
		System.out.print("Nhập hệ số lương: ");
		salaryCoe = Double.parseDouble(HumanResources.sc.nextLine());
		System.out.print("Nhập ngày vào làm: ");
		startDate = HumanResources.sc.nextLine();
		System.out.print("Nhập số ngày nghỉ phép: ");
		dayOff = Integer.parseInt(HumanResources.sc.nextLine());

	}

	// toString
	public String toString() {
		return "Mã nhân viên: " + id + " | Tên: " + name + " | Tuổi: " + age + " | Hệ số lương: " + salaryCoe
				+ " | Ngày vào làm: " + startDate + " | Số ngày nghỉ phép: "
				+ dayOff;
	}

}
