package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/4/11 20:58
 * @Version 1.0
 * @Description:
 */
public class LeetCode05 {
    public String longestPalindrome(String s) {
        int len = s.length();
        while(len > 0){
            for(int i = 0;i < s.length() - len + 1; i ++){
                if(isPalindrome(s,i,i+len-1))
                    return s.substring(i,len+i);
            }
            len --;
        }
        return "";
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode05 l = new LeetCode05();
        System.out.println(l.longestPalindrome(""));
    }
}
