package LeetCode.tencent_50Questions;

import java.math.BigInteger;

public class LeetCode231_2_isPowerOfTwo {
    //法一：
    public boolean isPowerOfTwo1(int n) {
        if(n < 1)
            return false;
        if(n != 1 && n % 2 != 0)
            return false;
        int temp = 1;
        while (temp > 0 && temp < n){
            temp *= 2;
        }
        return n == temp;
    }
    //法二：
    public static boolean isPowerOfTwo2(int n) {
        if(n < 0){
            return false;
        }
        while ((n & 0b1) == 0){
            n = n >> 1;
        }
        return n == 1;
    }
    //法三
    public static boolean isPowerOfTwo3(int n) {
        if(n <= 0){
            return false;
        }
        BigInteger bi = new BigInteger(n+"",10);
        String res = bi.toString(2);
        return res.lastIndexOf("1") == res.indexOf("1");
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo3(218));
    }
}
