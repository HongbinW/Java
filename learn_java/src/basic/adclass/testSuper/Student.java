package basic.adclass.testSuper;
public class Student extends Person{
	private String schoolName;
	int id = 1002;//学号

	public Student(){
		//super();
	}

	public Student(String schoolName){
		super("李雷",23);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public void eat() {
		System.out.println("学生吃饭");
	}

	public void info(){
		this.eat();
		super.eat();
		//super.sleep();
	}
	public void show(){
		System.out.println(this.id);//1002
		System.out.println(super.name);
		System.out.println(super.id);//1001
	}

}
