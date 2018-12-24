package basic.OOP.O3;

public class Eg2Boy {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void marry(Eg2Girl girl){
        System.out.println("我要娶" + girl.getName());
    }
    public void shout(){
        if(age > 22){
            System.out.println("可以结婚了");
        }else{
            System.out.println("恋爱ing");
        }
    }
}
