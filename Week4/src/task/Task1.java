package task;

abstract class Employee {
	private String name;
	private int age;
	private int eid;
	private double baseSalary;

	public Employee(String name, int age, int eid) {
		this.name = name;
		this.age = age;
		this.eid = eid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void orientation() {}
	
	public void printinfo() {
		System.out.println(this.name + " " + this.age + " " + this.eid);
	}
	
	public abstract double calculateSalary();
}

class Manager extends Employee {
	private int handlingEmployees;
	
	public Manager(String name, int age, int eid, int handlingEmployees) {
		super(name, age, eid);
		this.handlingEmployees = handlingEmployees;
	}
	
	public double calculateSalary() {
		double salary = 5000;
		salary = salary + this.handlingEmployees - this.handlingEmployees/4;
		return salary;
	}
	
	public void printinfo() {
		System.out.println("Name of the employee:" + this.getName() + " is " + this.getAge() + " years old. His employee id is: " + this.getEid() + ". Handling: " + this.handlingEmployees + ". Salary: " + calculateSalary());
	}
}

class Developer extends Employee {
	private int testingCodes;
	private int	developingCodes;
	
	public Developer(String name, int age, int eid, int testingCodes, int developingCodes) {
		super(name, age, eid);
		this.testingCodes = testingCodes;
		this.developingCodes = developingCodes;
	}
	
	public double calculateSalary() {
		double salary = 3500;
		salary = salary + this.testingCodes/4 + this.developingCodes/2;
		return salary;
	}
	
	public void printinfo() {
		System.out.println("Name of the employee:" + this.getName() + " is " + this.getAge() + " years old. His employee id is: " + this.getEid() + ". Testing Codes: " + this.testingCodes + " Developing codes: " + this.developingCodes + ". Salary: " + calculateSalary());
	}
}

class Designer extends Employee {
	private int noOfDesigns;
	
	public Designer(String name, int age, int eid, int noOfDesigns) {
		super(name, age, eid);
		this.noOfDesigns = noOfDesigns;
	}
	
	public double calculateSalary() {
		double salary = 2500;
		salary = salary + this.noOfDesigns/2;
		return salary;
	}
	
	public void printinfo() {
		System.out.println("Name of the employee:" + this.getName() + " is " + this.getAge() + " years old. His employee id is: " + this.getEid() + ". No of designs done: " + this.noOfDesigns + ". Salary: " + calculateSalary());
	}
}

public class Task1 {

	public static void main(String[] args) {
		
		Manager manager = new Manager("Jasmine", 45, 123, 5);
		Developer developer = new Developer("Aldo", 30, 345, 5, 2);
		Designer designer = new Designer("Chris", 25, 780, 4);
		
		Employee employee;
		
		employee = manager;
		employee.printinfo();
		
		employee = developer;
		employee.printinfo();
		
		employee = designer;
		employee.printinfo();
	}

}
