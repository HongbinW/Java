package questions;

public class test {
    public static void main(String[] args) {
        boolean flag = true;
        if(flag = false){    //flag本身就为boolean型，所以，赋值是多少最后就是多少
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }
}
