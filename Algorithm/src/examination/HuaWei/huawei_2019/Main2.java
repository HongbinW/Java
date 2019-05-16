package examination.HuaWei.huawei_2019;

import java.util.Scanner;
public class Main2 {
    public static int minManage(String word1,String word2){
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m + 1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j < n + 1; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String num = sc.nextLine();
            if(num.equals("")){
                break;
            }
            int N = Integer.parseInt(num);
            String[] ori = new String[N];
            String[] edt = new String[N];
            for(int i = 0; i < N; i++){
                ori[i] = sc.nextLine();
            }
            for(int i = 0; i < N; i++){
                edt[i] = sc.nextLine();
            }
            int res = 0;
            for(int i = 0; i < N; i++){
                res += minManage(ori[i],edt[i]);
            }
            System.out.println(res);
        }
    }
}
