package task2;

public class Animal {
	
	String name;
	int age;
	String color;
	
	Animal() {}
	
	Animal(String name, int age, String color) {
		this.name = name;
		this.age = age;
		this.color = color;
		System.out.println("In animal constructor");
	}
	
	void greetings() {
		System.out.println("The animal makes a sound");
	}
	
	void printinfo( ) {
		System.out.println("Animal information");
	}
}

class Dog extends Animal {
	
	Dog() {
		super("Milo", 2, "Brown");
		System.out.println("In dog constructor");
	}
	
	void greetings( ) {
		System.out.println("Woof woof");
	}
	
	void printinfo() {
		System.out.print("Dog " + this.name + " is " + this.age + " years old and is of " + this.color + " ");
	}
	
}

class Cat extends Animal {
	
	Cat() {
		super("Whiskey", 3, "Brown");
		System.out.println("In cat constructor");
	}
	
	void greetings( ) {
		System.out.println("Meow");
	}
	
	void printinfo() {
		System.out.print("Cat " + this.name + " is " + this.age + " years old and is of " + this.color + " ");
	}
	
}

class Duck extends Animal {
	
	Duck() {
		super("Do", 1, "White");
		System.out.println("In duck constructor");
	}
	
	void greetings( ) {
		System.out.println("Quack");
	}
	
	void printinfo() {
		System.out.print("Duck " + this.name + " is " + this.age + " years old and is of " + this.color + " ");
	}
	
}

class Pig extends Animal {
	
	Pig() {
		super("Po", 10, "Pink");
		System.out.println("In pig constructor");
	}
	
	void greetings( ) {
		System.out.println("Oink");
	}
	
	void printinfo() {
		System.out.print("Pig " + this.name + " is " + this.age + " years old and is of " + this.color + " ");
	}
	
}
