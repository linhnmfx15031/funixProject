package asm3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HumanResources {
	static List<Staff> staffList = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static Department deparment = new Department();

	@SuppressWarnings("finally")
	public static void main(String[] args) {
		// Menu chọn chức năng
		int choose;
		do {
			menu();
			choose = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (choose) {
			// Thêm mới nhân viên
			case 1:
				inputData();
				break;
			// DS toàn bộ nhân viên
			case 2:
				displayInfoAll();
				break;
			// Các bộ phận trong công ty
			case 3:
				depatrmentPart();
				break;
			// Nhân viên theo từng bộ phận
			case 4:
				displayOnDepartment();
				break;
			// Tìm kiếm thông tin nhân viên
			case 5:
				search();
				break;
			// Bảng lương của toàn nhân viên
			case 6:
				displaySalary();
				break;
			// Bảng lương theo thứ tự tăng dần
			case 7:
				sortByUp();
				break;
			// Bảng lương theo thứ tự giảm dần
			case 8:
				sortByDown();
				break;
			// Kết thúc chương trình
			case 9:
				System.out.println("Kết thúc chương trình!");
				break;
			default:
				try {
					System.out.println("Không có lựa chọn phù hợp vui lòng chọn lại!");
				} finally {
					break;
				}

			}
		} while (choose != 9);
	}

	// Menu chức năng
	static void menu() {
		System.out.println("MENU:");
		System.out.println("1. Thêm nhân viên mới vào công ty");
		System.out.println("2. Hiển thị danh sách nhân viên hiện có trong công ty");
		System.out.println("3. Hiển thị các bộ phận trong công ty");
		System.out.println("4. Hiển thị các nhân viên theo từng bộ phận");
		System.out.println("5. Tìm kiếm thông tin theo tên hoặc mã nhân viên");
		System.out.println("6. Hiển thị bảng lương của toàn nhân viên");
		System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
		System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
		System.out.println("9. Thoát");
		System.out.print("Chọn: ");
	}

	// Input nhập số lượng nhân viên cần thêm
	private static void inputData() {
		System.out.print("Nhập số lượng nhân viên cần thêm: ");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1) + ":");
			Staff staff = createStaff();
			staffList.add(staff);

		}

	}

	// Chọn bộ phận cần thêm nhân viên
	private static Staff createStaff() {
		Staff staff;

		System.out.println("Chọn bộ phận cần thêm:");
		System.out.println("1. Bộ phận Manager");
		System.out.println("2. Bộ phận Employee");
		System.out.print("Chọn: ");
		int choose;

		do {
			choose = Integer.parseInt(sc.nextLine());
			System.out.println();
			if(choose == 1) {
				staff = new Manager();
				departmentEmployee();
				staff.setDepartment(deparment);
				System.out.println("Nhập thông tin để thêm mới 1 Manager:");
				break;
			} else if (choose == 2) {
				staff = new Employee();
				departmentEmployee();
				staff.setDepartment(deparment);
				System.out.println("Nhập thông tin để thêm mới 1 Employee:");
				break;
			} else {
				System.out.println("Không có lựa chọn phù hợp vui lòng chọn lại!");
			}
		} while (true);
		
		staff.input();
		System.out.println();
		return staff;
	}

	// Hiển thị toàn bộ nhân viên
	private static void displayInfoAll() {
		for (Staff staff : staffList) {
			staff.displayInformation();
		}
	}
	// Hiển thị các bộ phận trong công ty
		public static void depatrmentPart() {
			System.out.println("Các bộ phận trong công ty: ");
			departmentManager();
			System.out.println(deparment.toString());
			departmentEmployee();
			System.out.println(deparment.toString());
			System.out.println();
		}
	// Bộ phận Manager
	public static void departmentManager() {
		deparment.departmentID = "MA";
		deparment.departmentName = "Manager";
	}
	// Bộ phận Employee
	public static void departmentEmployee() {
		deparment.departmentID = "EM";
		deparment.departmentName = "Employee";
	}
	// Hiển thị nhân viên theo từng bộ phận
	private static void displayOnDepartment() {
		System.out.println("Số lượng nhân viên theo từng bộ phận: ");
		int count = 0;
		for (Staff staff : staffList) {
			if (staff instanceof Employee) {
				count++;
			}
		}
		departmentEmployee();
		deparment.departmentNumbers = count;
		System.out.println(deparment.toString());
		
		count = 0;
		for (Staff staff : staffList) {
			if (staff instanceof Manager) {
				count++;
			}
		}
		departmentManager();
		deparment.departmentNumbers = count;
		System.out.println(deparment.toString());
		
		System.out.println();
	}

	// Tìm kiếm
	public static void search() {

		System.out.print("Nhập tên hoặc mã nhân viên cần tìm kiếm: ");
		String keyWord = sc.nextLine();
		int count = 0;
		for (Staff staff : staffList) {
			if(staff.getName().contains(keyWord)) {
				count++;
				System.out.println(staff.toString());
			} else if(staff.getId().contains(keyWord)) {
				count++;
				System.out.println(staff.toString());
			}
		}
		System.out.println();
		
		if(count == 0) {
			System.out.println("Không có nhân viên này trong công ty!\n");
		} else {
			System.out.println("Tìm thấy " + count + " kết quả!\n");
		}
	}

	// Hiển thị bảng lương
	private static void displaySalary() {
		for (Staff staff : staffList) {
			System.out.println("[Họ tên: " + staff.getName() + " | Mã nhân viên: " + staff.getId()
			+ " | Lương: " + Math.round(staff.getSalary()) + " vnd]\n");
		}
		System.out.println();
	}

	// Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
	private static void sortByUp() {
		System.out.println("Bảng lương nhân viên theo thứ tự tăng dần:");
		Collections.sort(staffList, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				if (o1.getSalary() > o2.getSalary()) {
					return 1;
				} else if (o1.getSalary() < o2.getSalary()) {
					return -1;
				} else {
					return 0;
				}

			}
		});

		displaySalary();
	}

	// Hiển thị bảng lương theo thứ tự giảm dần
	private static void sortByDown() {
		System.out.println("Bảng lương nhân viên theo thứ tự giảm dần:");
		Collections.sort(staffList, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				if (o1.getSalary() < o2.getSalary()) {
					return 1;
				} else if (o1.getSalary() > o2.getSalary()) {
					return -1;
				} else {
					return 0;
				}

			}
		});

		displaySalary();
	}
}
