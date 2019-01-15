package basic.collection.Experiment;

import java.util.*;

/**
 * 1. 定义一个Employee类，
 * 该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 *
 * MyDate类包含:
 * private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
 *
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 *
 * 1). 使Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
 */
public class TestEmployee{
    public static void main(String[] args){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    int year = e1.getBirthday().getYear().compareTo(e2.getBirthday().getYear());
                    int month = e1.getBirthday().getMonth().compareTo(e2.getBirthday().getMonth());
                    int day = e1.getBirthday().getDay().compareTo(e2.getBirthday().getDay());
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
        Employee e1 = new Employee("AB", 24,new MyDate(1, 15, 1991));
        Employee e2 = new Employee("ET", 23,new MyDate(4, 13, 1991));
        Employee e3 = new Employee("HJ", 22,new MyDate(3, 12, 1991));
        Employee e4 = new Employee("GDE", 21,new MyDate(11, 29, 1994));
        Employee e5 = new Employee("WEW", 21,new MyDate(12, 9, 1993));
        TreeSet set = new TreeSet(com);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
//        for(Object e:set){
//            System.out.println(e);
//        }
        Iterator i = set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
class Employee /*implements Comparable*/{
    private String name;
    private Integer age;
    private MyDate birthday;

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
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, birthday);
    }
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Employee) {
//            Employee em1 = (Employee) o;
//            return this.name.compareTo(em1.name);
//        }
//        return 0;
//    }
}
class MyDate{
    private Integer month;
    private Integer day;
    private Integer year;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public MyDate(Integer month, Integer day, Integer year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(month, myDate.month) &&
                Objects.equals(day, myDate.day) &&
                Objects.equals(year, myDate.year);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(month, day, year);
    }
}
