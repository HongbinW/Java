package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/4/11 22:23
 * @Version 1.0
 * @Description:
 */
public class LeetCode08 {
    public int myAtoi(String str) {
        int fu = 1;
        long num = 0;
        int curChar = 0;
        if(str == null || str.length() < 1){
            return 0;
        }
        while(curChar < str.length() && str.charAt(curChar) == ' '){
            curChar++;
        }
        if(curChar == str.length())
            return 0;
        if(str.charAt(curChar) == '-'){
            fu = -1;
            curChar++;
        }else if(str.charAt(curChar) == '+'){
            curChar ++;
        }
        while(curChar < str.length() && str.charAt(curChar) >= '0' && str.charAt(curChar) <= '9'){
            num = (num * 10) + str.charAt(curChar) - '0';
            curChar++;
            if(num * fu <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if(num * fu >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return (int)num * fu;
    }

}
