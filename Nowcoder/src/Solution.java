import java.util.ArrayList;

public class Solution {
    public boolean isValid(String str){
        int[] arr = new int[27];
        for (int i = 0 ; i < str.length(); i ++){
            if (str.charAt(i) == ' '){
                arr[26] ++;
                continue;
            }
            arr[str.charAt(i) - 'A']++;
        }
        int count = 0;
        for (int i = 0 ; i < 26 ; i ++){
            if (arr[i] >= 2){
                count ++;
            }
        }
        return count > arr[26];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("CAT RPC"));
    }
}