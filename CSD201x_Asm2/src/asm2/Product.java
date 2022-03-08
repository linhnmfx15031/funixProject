package asm2;

public class Product {
	private String bcode;
	private String title;
	private int quantity;
	private double price;

	public Product() {

	}

	public Product(String bcode, String title, int quantity, double price) {
		this.bcode = bcode;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void display() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return bcode + " | " + title + " | " + quantity + " | " + price;
	}
}
