package task1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter circle radius:");
		double rad = input.nextDouble();
		
		CircleFromSimpleGeometricObject circle = new CircleFromSimpleGeometricObject(rad);
		
		System.out.println("A circle " + circle.toString());
		System.out.println("The color is " + circle.getColor());
		System.out.println("The radius is " + circle.getRadius());
		System.out.println("The area is " + circle.getArea());
		System.out.println("The diameter is " + circle.getDiameter());
		
		System.out.println("Enter length of rectangle:");
		double len = input.nextDouble();
		System.out.println("Enter breadth of rectangle:");
		double br = input.nextDouble();
		RectangleFromSimpleGeometricObject rectangle = new RectangleFromSimpleGeometricObject(len,br);
		
		System.out.println("A rectangle " + rectangle.toString());
		System.out.println("The area is " + rectangle.getArea());
		System.out.println("The perimeter is " + rectangle.getPerimeter());
	}
}
