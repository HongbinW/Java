package tips;

import org.junit.Test;

public class basicdata {
    //int型数据，最小-2147483648，最大2147483647
    //LeetCode 整数反转
    @Test
    public void test1(){
        int x = 1534236469;
        long result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            System.out.println(0);
        System.out.println((int)result);    //将他反转的时候，超出了Int所以，需要控制范围
    }
}
