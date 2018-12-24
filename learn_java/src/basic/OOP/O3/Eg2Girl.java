package basic.OOP.O3;

public class Eg2Girl {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void marry(Eg2Boy boy){
        System.out.println("我要嫁给" + boy.getName());
        boy.marry(this);
    }
}
