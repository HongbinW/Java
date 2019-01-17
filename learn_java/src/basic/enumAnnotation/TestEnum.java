package basic.enumAnnotation;
//枚举：可以穷举

public class TestEnum {
    public static void main(String[] args) {
        season1 spring = season1.SPRING;
        System.out.println(spring);
        spring.show();
        System.out.println(spring.getSeasonDesc());
    }
}
//枚举类
class season1 {
    //1.提供类的属性，声明为private final类型
    private final String seasonName;
    private final String seasonDesc;
    //2.声明为final的属性，在构造器中初始化
    private season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.通过公共方法调用属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //4.创建枚举类的对象：将类的对象声明为public static fianl
    //若只有一个对象就是单例模式
    public static final season1 SPRING = new season1("Spring","warm");
    public static final season1 SUMMER = new season1("Summer","hot");
    public static final season1 AUTUMN = new season1("Autumn","cool");
    public static final season1 WINTER = new season1("Winter","cold");


    public void show(){
        System.out.println("这是一个季节");
    }
    @Override
    public String toString() {
        return "season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
