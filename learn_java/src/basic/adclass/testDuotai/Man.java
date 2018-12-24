package basic.adclass.testDuotai;

public class Man extends Person {
    private boolean smoking;
    public int id = 1002;
    public Man() {
    }
    public Man(boolean smoking){
        super();
        this.smoking = smoking;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void walk(){
        System.out.println("Man走路");
    }
    public void eat(){
        System.out.println("Man吃饭");
    }
    public void dance(){
        System.out.println("Man跳舞");
    }
}
