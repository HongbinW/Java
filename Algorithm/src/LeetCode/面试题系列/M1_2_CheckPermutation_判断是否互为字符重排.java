package LeetCode.面试题系列;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M1_2_CheckPermutation_判断是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        int[] arr = new int[256];
        for (int i = 0; i < s1.length(); i ++){
            arr[s1.charAt(i)] ++;
            arr[s2.charAt(i)] --;
        }
        for (int i = 0; i < 256; i ++){
            if (arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
