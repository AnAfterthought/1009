package task;

interface Shape {
	double PI = Math.PI;
	public void area();
}

class Rectangle implements Shape {
	private double dim1;
	private double dim2;
	
	Rectangle(double dim1, double dim2) {
		this.dim1 = dim1;
		this.dim2 = dim2;
	}
	
	public void area() {
		System.out.println("Inside Area for Rectangle.\nArea is " + this.dim1 * this.dim2);
	}
}

class Triangle implements Shape {
	private double dim1;
	private double dim2;
	
	Triangle(double dim1, double dim2) {
		this.dim1 = dim1;
		this.dim2 = dim2;
	}
	
	public void area() {
		System.out.println("Inside Area for Triangle.\nArea is " + this.dim1 * this.dim2 * 0.5);
	}
}

class Circle implements Shape {
	private double dim1;
	private double dim2;
	
	Circle(double dim1, double dim2) {
		this.dim1 = dim1;
		this.dim2 = dim2;
	}
	
	public void area() {
		System.out.println("Inside Area for Circle.\nArea is " + this.dim1 * this.dim2 * PI);
	}
}

class Ellipse implements Shape {
	private double dim1;
	private double dim2;
	
	Ellipse(double dim1, double dim2) {
		this.dim1 = dim1;
		this.dim2 = dim2;
	}

	public void area() {
		System.out.println("Inside Area for Ellipse.\nArea is " + this.dim1 * this.dim2 * PI);
	}
}

class Square implements Shape {
	private double dim1;
	private double dim2;
	
	Square(double dim1, double dim2) {
		this.dim1 = dim1;
		this.dim2 = dim2;
	}
	
	public void area() {
		System.out.println("Inside Area for Square.\nArea is " + this.dim1 * this.dim2);
	}

}

public class Task2 {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(9, 5);
		Triangle t = new Triangle(10, 8);
		Circle c = new Circle(5, 5);
		Ellipse e = new Ellipse(7 ,7);
		Square s = new Square(6, 6);
		Shape figref;
		
		figref = r;
		figref.area();
		
		figref = t;
		figref.area();
		
		figref = c;
		figref.area();
		
		figref = e;
		figref.area();
		
		figref = s;
		figref.area();
	}
}
