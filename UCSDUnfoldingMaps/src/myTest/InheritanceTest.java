package myTest;

public class InheritanceTest {

	public static void main(String[] args) {
		/*
		Student s = new Student();
		Person p = new Person();
		Person q = new Person();
		Faculty f = new Faculty();
		Object o = new Faculty();

		String n = s.getName();
		p = s;
		int m = ((Student)p).getId();
		System.out.println("m: " + m);

		q = f;
		f = (Faculty)q;
		*/
	}

}

class Person extends Object{
	private String name;

	public Person(String n){
		super();
		this.name = n;
	}
	public String getName() {
		return name;
	}

	public void setName(String n){
		this.name = n;
	}
}

class Student extends Person {
	private int id;

	public int getId() {
		return id;
	}

	public Student(String n){
		super(n);

		//this.name = n;
	}
}

class Faculty extends Person {
	private String id;

	public Faculty(String n){
		super(n);
	}
	public String getId() {
		return id;
	}
}