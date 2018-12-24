package basic.adclass2.testAbstractClass;

/**
 * 编写工资系统，实现不同类型员工(多态)的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。
 */

import java.util.Scanner;

/**
 * 实验说明：
 * （1）定义一个Employee类，该类包含：
 * 	private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
 * 	abstract方法earnings()；toString()方法输出对象的name,number和birthday。
 */
abstract class Employee1{
    private String name;
    private int number;
    private MyDate birthday;

    public abstract double earnings();

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString() +
                ']';
    }

    public Employee1() {
    }

    public Employee1(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}
/**
 * （2）MyDate类包含:
 * 	private成员变量month,day,year；
 * 	toDateString()方法返回日期对应的字符串：xxxx年xx月xx日
 */
class MyDate{
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toDateString(){
        return year + "年" + month + "月" + day + "日";
    }
}
/**
 * （3）定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。该类包括：
 * 	private成员变量monthlySalary；
 * 实现父类的抽象方法earnings(),该方法返回monthlySalary值；toString()方法输出员工类型信息及员工的name，number,birthday。
 */
class SalariedEmployee2 extends Employee1{
    private double monthlySalary;
    public double earnings(){
        return monthlySalary;
    }

    public SalariedEmployee2(String name,int number,MyDate birthday,double monthlySalary) {
        super(name,number,birthday);
        this.monthlySalary = monthlySalary;
    }

    public String toString() {
        return  "Salaried Employee {" + super.toString()  + "monthlySalary = " + monthlySalary+ "}";
    }
}
/**（4）参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：
 private成员变量wage和hour；
 实现父类的抽象方法earnings(),该方法返回wage*hour值；toString()方法输出员工类型信息及员工的name，number,birthday。
 */
class HourlyEmployee extends Employee1{
    private double wage;
    private double hour;
    public double earnings(){
        return wage * hour;
    }

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, double hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public String toString() {
        return "Hourly Employee {" + super.toString() + "wage = " + wage + ",hour = " + hour +"}" ;
    }
}
/**
 * （4）定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。利用循环结构遍历数组元素，
 * 输出各个对象的类型,name,number,birthday,以及该对象生日。当键盘输入本月月份值时，如果本月是某个Employee对象的生日，
 * 还要输出增加工资信息。
 */
public class TestAbstract2{
    public static void main(String[] args){
        Employee1[] emps = new Employee1[2];
        emps[0] = new SalariedEmployee2("ab",1001,new MyDate(12,21,1995),
                5000);
        emps[1] = new HourlyEmployee("cd",1002,new MyDate(10,3,1995),
                100,6);
        Scanner s = new Scanner(System.in);
        System.out.println("请输入本月的月份");
        int month = s.nextInt();
        for(int i = 0 ; i < emps.length ; i++){
            if(month == emps[i].getBirthday().getMonth()){
                System.out.println("加工资");
            }
            System.out.println(emps[i]);
        }
    }
}