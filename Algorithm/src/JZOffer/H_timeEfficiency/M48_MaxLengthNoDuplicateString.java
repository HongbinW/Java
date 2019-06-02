package JZOffer.H_timeEfficiency;
//没有OJ
public class M48_MaxLengthNoDuplicateString {
    public static int maxLengthStringWithoutDuplication(String str){
        int[] dp = new int[str.length()];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < str.length(); i++){
            int start = str.substring(0,i).lastIndexOf(str.charAt(i));  //第i个字符上次出现的位置
            if (start < i - dp[i-1]){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = i - start;
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthStringWithoutDuplication("arabcacfr"));
    }
}
