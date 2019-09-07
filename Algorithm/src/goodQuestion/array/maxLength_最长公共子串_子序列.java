package goodQuestion.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/4 22:52
 * @Version 1.0
 * @Description:
 */
public class maxLength_最长公共子串_子序列 {
    public static String process(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        String str = new String();
        for (int i = 0; i < dp.length; i ++){
            for (int j = 0; j < dp[0].length; j ++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > max){
                        max = dp[i][j];
                        str = str1.substring(i-max,i);
                    }
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
//        System.out.println(process("msatgfqpleswalkvowbcjllbmtxdjqtxlxoyrobrnpuctrcowegmyjjmgkzibmbplpslbsfawrqmzeckiwctwizhpkthvqaukxmzhyqbhhjbihzoidheibsrfbzaruhlwoiwlexwoaicikadrhcvevcnwxwsskooedipgftdfcmdpdonvjtzsncuylrbfzstplfsnebivzdyhhbajfokqvscrzobdzgnfkeqfhzpugbekegaiidhervdsgc","kicndbvtazczllcipodvlrliqargjayiivkuymrusywvotxycdzscogyejpvfmrldueulwijytocrf"));
        process2("bbbab","babbb");

    }
    //最长公共子序列长度
    public static void process2(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i ++ ) {
            for (int j = 1; j < dp[0].length; j ++ ) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(s1.length() - dp[s1.length()][s2.length()]);
    }
}
