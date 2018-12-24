package basic.adclass2.testStatic;

public class TestSportsMan {
    public static void main(String[] args){
        SportsMan s1 = new SportsMan("ab",23,"ch");
        SportsMan s2 = new SportsMan("cd",21,"ch");
        s1.nation = "China";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(SportsMan.nation);
        s1.show1();
        SportsMan.show();   //类调用
        s1.show();  //对象调用
    }
}

class SportsMan{
    //实例变量（随着对象的创建而被加载）
    String name;
    int age;
    //类变量
    static String nation;

    public SportsMan(String name, int age,String nation) {
        this.name = name;
        this.age = age;
        this.nation = nation;   //构造器不看静态非静态，当做非静态方法来用即可
    }

    @Override
    public String toString() {
        return "SportsMan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}';
    }
    public void show1(){
        System.out.println("I'm a China athlete.");
    }
    public static void show(){
        System.out.println("nation： " + nation);
        System.out.println("I'm a China athlete.");
        info();
    }
    public static void info(){
        System.out.println("I'm a static method");
    }
}
