package LeetCode.explore_tencent.arrayString;

/**
 * @Author: HongbinW
 * @Date: 2019/9/7 13:24
 * @Version 1.0
 * @Description:
 */
public class longestPalindrome {
    public static String longestPalindrome(String s) {
        int resMin = 0, resMax = 0;
        for (int i = 0; i < s.length(); i ++){
            int left = i, right = i;
            while (left >= 0 && right < s.length()){
                if (s.charAt(left) == s.charAt(right)){
                    left --;
                    right ++;
                }else {
                    break;
                }
            }
            if (resMax - resMin < right - left - 1){
                resMax = right;
                resMin = left + 1;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()){
                if (s.charAt(left) == s.charAt(right)){
                    left --;
                    right ++;
                }else {
                    break;
                }
            }
            if (resMax - resMin < right - left - 1){
                resMax = right;
                resMin = left + 1;
            }
        }
        return s.substring(resMin,resMax);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
    }
}
