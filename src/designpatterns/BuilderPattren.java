package designpatterns;

public class BuilderPattren {

	public static void main(String[] args) {

	}

}

class Computer {
	private String cpu;
	private String ram;
	private String disc;

	private String color;
	private int size;
	private double price;

	private Computer(String cpu, String ram, String disc) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.disc = disc;
	}

	public String getColor() {
		return color;
	}

	public Computer setColor(String color) {
		this.color = color;
		return this;
	}

	public int getSize() {
		return size;
	}

	public Computer setSize(int size) {
		this.size = size;
		return this;
	}

	public double getPrice() {
		return price;
	}

	public Computer setPrice(double price) {
		this.price = price;
		return this;
	}

}