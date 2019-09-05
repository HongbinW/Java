package goodQuestion.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/4 22:52
 * @Version 1.0
 * @Description:
 */
public class maxLength_最长公共字符串 {
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
        System.out.println(process("msatgfqpleswalkvowbcjllbmtxdjqtxlxoyrobrnpuctrcowegmyjjmgkzibmbplpslbsfawrqmzeckiwctwizhpkthvqaukxmzhyqbhhjbihzoidheibsrfbzaruhlwoiwlexwoaicikadrhcvevcnwxwsskooedipgftdfcmdpdonvjtzsncuylrbfzstplfsnebivzdyhhbajfokqvscrzobdzgnfkeqfhzpugbekegaiidhervdsgc","kicndbvtazczllcipodvlrliqargjayiivkuymrusywvotxycdzscogyejpvfmrldueulwijytocrf"));


    }
}
