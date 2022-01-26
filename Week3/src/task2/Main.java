package task2;

public class Main {

	public static void main(String[] args) {
		
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal duck = new Duck();
		Animal pig = new Pig();
		
		dog.printinfo();
		dog.greetings();
		
		cat.printinfo();
		cat.greetings();
		
		duck.printinfo();
		duck.greetings();
		
		pig.printinfo();
		pig.greetings();
	}

}
