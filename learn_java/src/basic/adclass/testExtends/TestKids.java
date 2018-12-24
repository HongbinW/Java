package basic.adclass.testExtends;

public class TestKids {
    public static void main(String[] args) {
        Kids someKid = new Kids();
        someKid.setSex(1);
        someKid.setSalary(0);
        someKid.setYearsold(13);

        someKid.employeed();
        someKid.manOrWorman();
        someKid.printAge();
    }
}
