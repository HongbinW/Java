package nowcode.LeetCode.middle;

import java.util.Set;

public class wordBreak_i_分解单词 {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0){
            return false;
        }
        boolean[] flag = new boolean[s.length() + 1];   // 到第i个字符能成功匹配[)
        flag[0] = true;
        for (int i = 1; i <= s.length(); i ++){
            for (int j = i - 1; j >= 0; j --){
                if (flag[j] && dict.contains(s.substring(j,i))){
                    flag[i] = true;
                    break;
                }else {
                    flag[i] = false;
                }
            }
        }
        return flag[s.length()];
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(0,1));
    }
}
