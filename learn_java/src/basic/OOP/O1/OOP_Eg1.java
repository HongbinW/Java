package basic.OOP.O1;
/*
 *创建一个Person类，其定义如下：
 * 要求：(1)创建Person类的对象，设置该对象的name、age和sex属性，调用study方法，输出字符串“studying”，
 *      调用showAge()方法显示age值，调用addAge()方法给对象的age属性值增加2岁。
 *      (2)创建第二个对象，执行上述操作，体会同一个类的不同对象之间的关系。
 *

 */
public class OOP_Eg1 {
    public static void main(String[] args){
        person dg = new person();
        dg.name = "cjy";
        dg.age = 22;
        dg.study();
        dg.showAge();
        dg.addAge(2);
        dg.showAge();
        person dg2 = new person();
        dg2.showAge();
    }
}
class person{
    String name;
    int age;
    boolean sex;

    public void study(){
        System.out.println("studying");
    }
    public void showAge(){
        System.out.println(age);
    }
    public int addAge(int n){
        age += n;
        return age;
    }

}
