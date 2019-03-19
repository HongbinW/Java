package JZOffer.B_Algorithm;

import java.io.FileOutputStream;

/**
 * @Author: HongbinW
 * @Date: 2019/3/16 10:32
 * @Version 1.0
 */
public class M10_Fibonacci {
    public static int Fibonacci(int target){
        if(target == 1)
            return 1;
        if(target == 2)
            return 1;
        return Fibonacci(target-2)+Fibonacci(target-1);
    }
    public static int Fibonacci2(int target){
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int one = 1;
        int two = 2;
        int sum = 0;
        for(int i = 3; i < target; i++){
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci2(5));
    }
}
