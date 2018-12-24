package basic.adclass.testSuper;

public class Person {

	protected String name;
	protected int age;
	int id = 1001;//人的身份证号
	public Person() {
		//super();
		System.out.println("这是Person空参的构造器！");
		this.name = "AA";
		this.age = 1;
	}

	public Person(String name) {
		this();
		this.name = name;
	}

	public Person(String name, int age) {
		this(name);
		this.age = age;
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

	public void eat() {
		System.out.println("eating");
	}

	public void sleep() {
		System.out.println("sleeping");
		this.eat();
	}
	// 比较当前对象与形参的对象的age谁大。
	public int compare(Person p) {
		if (this.age > p.age)
			return 1;
		else if (this.age < p.age)
			return -1;
		else
			return 0;
	}

}
