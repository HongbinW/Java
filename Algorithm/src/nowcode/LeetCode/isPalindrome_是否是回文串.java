package nowcode.LeetCode;
//仅考虑字符串中的字母字符和数字字符，并且忽略大小写
public class isPalindrome_是否是回文串 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        int left = 0, right = s.length()-1;
        while (left < right){
            while (left < right && !isValid(s.charAt(left))){
                left ++;
            }
            while (left < right && !isValid(s.charAt(right))){
                right --;
            }
            while (left < right && isValid(s.charAt(left)) && isValid(s.charAt(right))){
                if (s.charAt(left) == s.charAt(right)){
                    left ++;
                    right --;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char c){
        if ((c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'
                || c >= '0' && c <= '9')){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new isPalindrome_是否是回文串().isPalindrome("aA"));
    }
}
