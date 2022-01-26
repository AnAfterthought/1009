package task1;

public class RectangleFromSimpleGeometricObject extends GeometricObject{

	double width;
	double height;
	
	RectangleFromSimpleGeometricObject() {}
	
	RectangleFromSimpleGeometricObject(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	RectangleFromSimpleGeometricObject(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		this.color = color;
		this.filled = filled;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		double area = width * height;
		return area;
	}
	
	public double getPerimeter() {
		double perimeter = width * 2 + height * 2;
		return perimeter;
	}
}
