package asm3;

public class Department {
	public String departmentName;
	public String departmentID;
	public int departmentNumbers;

	public String toString() {
		return departmentID + "-" + departmentName + ": " + departmentNumbers;
	}

}