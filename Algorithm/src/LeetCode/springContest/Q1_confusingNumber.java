package LeetCode.springContest;

/**
 * @Author: HongbinW
 * @Date: 2019/4/14 16:37
 * @Version 1.0
 * @Description:
 * 给定一个数字 N，当它满足以下条件的时候返回 true：
 *
 * 把原数字旋转180°以后得到新的数字。
 *
 * 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 *
 * 2, 3, 4, 5, 7 旋转 180° 后,得到的不是数字。
 *
 * 易混淆数字 (confusing number) 就是一个数字旋转180°以后，得到和原来不同的数字，且新数字的每一位都是有效的。
 *
 * 输入：89
 * 输出：true
 * 解释:
 * 把 89 旋转 180° 以后得到 68，86 是有效数字且 86!=89 。
 */
public class Q1_confusingNumber {
    public static boolean confusingNumber(int N) {
        String str = String.valueOf(N);
        if(str.contains("2"+"") || str.contains("3"+"") || str.contains("4"+"") || str.contains("5"+"") || str.contains("7"+"")){
            return false;
        }
        String revStr = "";
        for(int i = str.length() -1 ; i >= 0; i--){
            if(str.charAt(i) == '6') {
                revStr += '9';
                continue;
            }
            else if(str.charAt(i) == '9'){
                revStr += '6';
                continue;
            }else {
                revStr += str.charAt(i);
            }
        }
        int revN = Integer.parseInt(revStr);
        if(N == revN)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(confusingNumber(916));
    }
}
