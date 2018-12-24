package basic.adclass2;

public class TestMain1 {
    public static void main(String[] args){
        Main.main(new String[10]);
    }
}
class Main{
    public static void main(String[] args){ //执行TestMain1，把Main中的main看做一个普通的方法
        for(int i = 0; i < args.length; i++){
            args[i] = "value_" + i;
            System.out.println(args[i]);
        }
    }
}
