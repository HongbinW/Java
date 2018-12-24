package basic.OOP.O2;

/**
 * 1.创建程序,在其中定义两个类：Person和TestPerson类。定义如下：
 *     用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。
 *     在TestPerson类中实例化Person类的对象b，调用setAge()和getAge()方法，体会Java的封装性。
 */
public class FZ_Eg1 {
    public static void main(String[] args){
        person p1 = new person();
//        p1.setAge(120);
        p1.setAge(150);
        System.out.println(p1.getAge());
    }
}

class person{
    private int age;

    public void setAge(int n) {
        if (n > 0 && n < 130){
        age = n;}
        else{
//            System.out.println("Wrong!");
            throw new RuntimeException("您输入数据有误");
        }
    }
    public int getAge(){
        return age;
    }
}
