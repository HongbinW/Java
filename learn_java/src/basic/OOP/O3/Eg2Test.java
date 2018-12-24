package basic.OOP.O3;

public class Eg2Test {
    public static void main(String[] args){
        Eg2Boy boy = new Eg2Boy();
        boy.setName("abc");
        boy.setAge(23);
        Eg2Girl girl = new Eg2Girl();
        girl.setName("def");
        boy.marry(girl);
        boy.shout();
        girl.marry(boy);
    }
}
