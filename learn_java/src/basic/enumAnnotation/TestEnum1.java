package basic.enumAnnotation;
/*
    一、如何自定义枚举类(见TestEnum)
    二、如何使用enum关键字定义枚举类
            >常用方法：values()以数组形式返回枚举类所有对象，valueOf(Sring name)
            >如何让枚举类实现接口：可以正常地用类实现接口，也可以在枚举类那定义好，让不同枚举类对象调用重写的方法执行效果不同（即每个对象重写抽象方法）
 */
public class TestEnum1 {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        spring.show();
        System.out.println(spring.getSeasonDesc());
        System.out.println();
        //1.values()
        Season[] seasons = Season.values();
        for(int i = 0;i < seasons.length;i++){
            System.out.println(seasons[i]);
        }
        System.out.println();
        //2.valueOf(String name):要求传入的形参name是枚举类对象的名字，否则报java.lang.IllegalArgumentException异常
        String str = "SPRING";
        Season sea = Season.valueOf(str);
        System.out.println(sea);
    }
}
interface Info{
    void show();
}
enum Season implements Info{
    //1.必须将枚举类对象放在最上面，注意标点符号
    SPRING("Spring","warm"){
        public void show(){
            System.out.println("春天在哪里");
        }
    },
    SUMMER("Summer","hot"){
        public void show(){
            System.out.println("生如夏花");
        }
    },
    AUTUMN("Autumn","cool"){
        public void show(){
            System.out.println("秋高气爽");
        }
    },
    WINTER("Winter","cold"){
        public void show(){
            System.out.println("白雪皑皑");
        }
    };

    private final String seasonName;
    private final String seasonDesc;


    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }



//    public void show(){
//        System.out.println("这是一个季节");
//    }
    @Override
    public String toString() {
        return "season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}