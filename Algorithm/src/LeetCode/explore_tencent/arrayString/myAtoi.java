package LeetCode.explore_tencent.arrayString;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author: HongbinW
 * @Date: 2019/9/8 15:58
 * @Version 1.0
 * @Description:
 */
public class myAtoi {
    public int myAtoi(String str) {
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' '){
            index++;
        }
        if (index == str.length()){
            return 0;
        }
        int flag = 1;
        if (str.charAt(index) == '-'){
            flag = -1;
            index ++;
        }else if (str.charAt(index) == '+'){
            flag = 1;
            index ++;
        }
        long res = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            res = res * 10 + str.charAt(index) - '0';
            index ++;
            if (res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if (res * flag < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)res * flag;
    }
}
