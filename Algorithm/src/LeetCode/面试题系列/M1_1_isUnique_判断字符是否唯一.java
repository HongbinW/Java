package LeetCode.面试题系列;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M1_1_isUnique_判断字符是否唯一 {
    public boolean isUnique(String astr) {
        int[] arr = new int[128];
        for (int i = 0; i < astr.length(); i ++){
            if (arr[astr.charAt(i)] != 0){
                return false;
            }
            arr[astr.charAt(i)] ++;
        }
        return true;
    }
    //不用额外数组
    // 用一个数表示，如果这个字符都是小写字母，则2^26即可表示所有字母
    public boolean isUnique2(String astr) {
       return true;
    }
}
