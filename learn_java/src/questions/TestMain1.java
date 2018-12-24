package questions;

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


//Question:
/*
    main函数被static修饰，那理应存在于静态域中，那对于此段代码的两个main函数，是分别存在与静态域的各自类中吗？
 */