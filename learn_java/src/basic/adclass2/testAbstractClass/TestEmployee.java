package basic.adclass2.testAbstractClass;

/**
 * 编写一个Employee类，声明为抽象类，包含如下三个属性：name，id，salary。提供必要的构造器和抽象方法：work()。
 * 对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。请使用继承的思想，设计CommonEmployee类和Manager类，
 * 要求类中提供必要的方法进行属性访问。
 */
abstract class Employee{
    private String name;
    private int id;
    protected double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();
}
class CommonEmployee extends Employee{
    public void work(){
        System.out.println("CommonEmployee Work");
    }
}
class Manager extends Employee{
    private double bonus;
    public void work(){
        System.out.println("Manager Work");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
public class TestEmployee {
    public static void main(String[] args){
        Employee e = new Manager();
        e.work();
        Employee e1 = new CommonEmployee();
        e1.work();
    }
}
