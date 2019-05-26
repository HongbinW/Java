package LeetCode.tencent_50Questions;

public class LeetCode557_reverseWordIII {
    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        String res = "";
        for(int i = 0; i < strs.length; i++){
            res += reverseProcess(strs[i]);
            if(i != strs.length-1){
                res += " ";
            }
        }
        return res;
    }
    public static String reverseProcess(String str){
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length/2; i++){
            swap(chs,i,chs.length-1-i);
        }
        return new String(chs);
    }
    public static void swap(char[] chs, int i, int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's"));
    }
}
