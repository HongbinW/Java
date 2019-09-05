package LeetCode.tencent_50Questions;

public class LeetCode557_reverseWordIII {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int startIndex = 0;
        while (startIndex < s.length()){
            int endIndex = s.indexOf(' ', startIndex + 1);
            if(endIndex == -1){
                endIndex = s.length();
            }
            reverse(startIndex, endIndex, chars);
            startIndex = endIndex + 1;
        }
        return String.valueOf(chars);

    }

    private static void reverse(int startIndex, int endIndex, char[] chars) {
        for(int i = startIndex, k= endIndex-1; i < k; i++, k--){
            char temp = chars[i];
            chars[i] = chars[k];
            chars[k] = temp;
        }

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's"));
    }
}
