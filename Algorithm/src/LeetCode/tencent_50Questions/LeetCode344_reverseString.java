package LeetCode.tencent_50Questions;

/**
 * @Author: HongbinW
 * @Date: 2019/8/31 15:33
 * @Version 1.0
 * @Description:
 */
public class LeetCode344_reverseString {
    public void reverseString(char[] s) {
        for (int i = 0 ; i < s.length / 2; i ++){
            swap(s,i,s.length-1-i);
        }
    }
    public void swap(char[] chs, int i, int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
