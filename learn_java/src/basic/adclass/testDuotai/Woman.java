package basic.adclass.testDuotai;

public class Woman extends Person{
    private boolean Beauty;

    public Woman() {
    }
    public Woman(boolean Beauty){
        this.Beauty = Beauty;
    }


    public boolean isBeauty() {
        return Beauty;
    }

    public void setBeauty(boolean beauty) {
        Beauty = beauty;
    }
    public void shooping(){
        System.out.println("Woman go shopping");
    }
}
