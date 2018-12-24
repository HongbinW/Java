package basic.adclass.testExtends;

public class Kids extends ManKind {
    int yearsold;

    public int getYearsold() {
        return yearsold;
    }

    public void setYearsold(int yearsold) {
        this.yearsold = yearsold;
    }

    public void printAge(){
        System.out.println(yearsold);
    }
    public void employeed(){    //父类方法重写
        System.out.println("Kis should study and no job");
    }
}

