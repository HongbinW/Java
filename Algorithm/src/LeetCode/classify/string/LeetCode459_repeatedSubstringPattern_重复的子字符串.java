package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/6
 */
public class LeetCode459_repeatedSubstringPattern_重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        for (int i = 1; i < s.length(); i ++){
            if (s.charAt(i) == s.charAt(0)){
                int index = 0;
                int len = i - 0;
                while(index < s.length() && s.indexOf(s.substring(0,i),index) == index){
                    index += len;
                }
                if (index == s.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(new LeetCode459_repeatedSubstringPattern_重复的子字符串().repeatedSubstringPattern2(s));
    }

    public boolean repeatedSubstringPattern2(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        for (int i = s.length()/2; i > 0; i --){
            if (s.length() % i == 0){
                int c = s.length() / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < c; j ++){
                    sb.append(s.substring(0,i));
                }
                if (sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
