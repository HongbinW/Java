package LeetCode.explore_byteDance.String;

//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
//换句话说，第一个字符串的排列之一是第二个字符串的子串。
/**
 * @Author: HongbinW
 * @Date: 2019/7/21 22:39
 * @Version 1.0
 * @Description:
 */
public class Q3_checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length() || s1 == null || s2 == null){
            return false;
        }
        int[] diff = new int[26];
        for (int i = 0;i < s1.length(); i ++){
            //第一遍，s1的+，s2的-
            diff[s1.charAt(i) - 'a'] ++;
            diff[s2.charAt(i) - 'a'] --;
        }
        int left = 0;
        int right = s1.length();
        boolean flag = isSame(diff);
        while (!flag && right < s2.length()){
            //第一遍时s2左侧的字符的数量都是减去，此处就给加上
            diff[s2.charAt(left) - 'a'] ++;
            diff[s2.charAt(right) - 'a'] --;
            left++;
            right++;
            flag = isSame(diff);
        }
        return flag;
    }

    private boolean isSame(int[] arr){
        for (int i = 0; i < arr.length; i ++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q3_checkInclusion().checkInclusion("ab",
                "eidbaooo"));
//        new Q3_checkInclusion().process("abc".toCharArray(),"abcd",0);
    }
}
