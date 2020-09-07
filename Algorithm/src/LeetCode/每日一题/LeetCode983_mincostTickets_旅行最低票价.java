package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/6
 */
public class LeetCode983_mincostTickets_旅行最低票价 {
    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }
    public static int mincostTickets(int[] days, int[] costs) {
        int len = days[days.length-1];
        int[] dp = new int[len+1];
        for(int i = 0; i < days.length; i ++){
            dp[days[i]] = costs[0] * (i + 1);
        }
        for(int i = 1; i <= len; i ++){
            if(dp[i] == 0){
                dp[i] = dp[i-1];
            }
            if (i-1 >= 0){
                dp[i] = Math.min(dp[i],dp[i-1]+costs[0]);
            }
            if(i-7 >= 0){
                dp[i] = Math.min(dp[i], dp[i-7] + costs[1]);
            }else{
                dp[i] = Math.min(dp[i],costs[1]);
            }
            if(i-30 >= 0){
                dp[i] = Math.min(dp[i], dp[i-30] + costs[2]);
            }else{
                dp[i] = Math.min(dp[i],costs[2]);
            }
        }
        return dp[len];
    }
}
