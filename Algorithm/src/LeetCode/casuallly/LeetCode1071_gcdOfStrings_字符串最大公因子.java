package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/12
 */
public class LeetCode1071_gcdOfStrings_字符串最大公因子 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)){
            return "";
        }
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
