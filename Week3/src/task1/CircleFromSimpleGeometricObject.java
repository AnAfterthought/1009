package task1;

public class CircleFromSimpleGeometricObject extends GeometricObject{
	
	double radius;
	
	CircleFromSimpleGeometricObject() {}
	
	CircleFromSimpleGeometricObject(double radius) {
		this.radius = radius;
	}
	
	CircleFromSimpleGeometricObject(double radius, String color, boolean filled) {
		this.radius = radius;
		this.color = color;
		this.filled = filled;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}
	
	public double getDiameter() {
		double diameter = radius * 2;
		return diameter;
	}
	
	public double getPerimeter() {
		double perimeter = Math.PI * getDiameter();
		return perimeter;
	}
}
