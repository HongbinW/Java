package examination.tencent.nowcoder2017_summer;

import java.util.Scanner;

/**
 * @Author: HongbinW
 * @Date: 2019/9/4 20:22
 * @Version 1.0
 * @Description:
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(process(str));
        }
    }
    public static int process(String str){
        String str2 = new StringBuilder(str).reverse().toString();
        int[][] dp = new int[str.length()+1][str2.length()+1];
        for (int i = 1; i < dp.length; i ++){
            for (int j = 1; j < dp.length; j ++){
                dp[i][j] = str.charAt(i-1) == str2.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return str.length() - dp[dp.length-1][dp.length-1];
    }
}
