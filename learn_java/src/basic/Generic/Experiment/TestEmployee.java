package basic.Generic.Experiment;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 1. 定义一个Employee类，
 * 该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 *
 * MyDate类包含:
 * private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
 *
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（TreeSet 需使用泛型来定义），
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 *
 * 1). 使Employee 继承 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
 */
public class TestEmployee {
    public static void main(String[] args) {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee1 && o2 instanceof Employee1){
                    Employee1 e1 = (Employee1)o1;
                    Employee1 e2 = (Employee1)o2;
                    MyDate birthday1 = e1.getBirthday();
                    MyDate birthday2 = e2.getBirthday();
                    int year = birthday1.getYear().compareTo(birthday2.getYear());
                    int month = birthday1.getMonth().compareTo(birthday2.getMonth());
                    int day = birthday1.getDay().compareTo(birthday2.getDay());
                    if(year != 0){
                        return year;
                    }else if(month != 0){
                        return month;
                    }else {
                        return day;
                    }
                }
                return 0;
            }
        };
        Employee1 e1 = new Employee1("AA",23,new MyDate(1996,1,19));
        Employee1 e2 = new Employee1("CC",27,new MyDate(1994,1,9));
        Employee1 e3 = new Employee1("EE",25,new MyDate(1992,3,4));
        Employee1 e4 = new Employee1("PP",22,new MyDate(1991,9,18));
        Employee1 e5 = new Employee1("WW",21,new MyDate(1991,8,23));
        TreeSet<Employee1> set = new TreeSet<Employee1>(comparator);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator<Employee1> i = set.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
class Employee implements Comparable{
    private String name;
    private Integer age;
    private MyDate birthday;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public Employee() {
    }

    public Employee(String name, Integer age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee e = (Employee)o;
            return this.name.compareTo(e.name);
        }
        return 0;
    }
}
class MyDate{
    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate() {
    }

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}