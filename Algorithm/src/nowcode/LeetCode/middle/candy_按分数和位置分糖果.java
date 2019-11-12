package nowcode.LeetCode.middle;

import java.util.Arrays;

//https://www.nowcoder.com/practice/74a62e876ec341de8ab5c8662e866aef?tpId=46&tqId=29045&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
//正着分一遍，反着分一遍（检查，纠正）
public class candy_按分数和位置分糖果 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0){
            return 0;
        }
        int[] help = new int[ratings.length];
        Arrays.fill(help,1);
        for (int i = 1; i < ratings.length; i ++){
            if (ratings[i] > ratings[i-1]){
                help[i] = help[i-1] + 1;
            }
        }
        int res = help[help.length-1];
        for (int i = help.length-2; i >= 0; i --){
            if (ratings[i] > ratings[i+1] && help[i] <= help[i+1]){
                help[i] = help[i+1] + 1;
            }
            res += help[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new candy_按分数和位置分糖果().candy(new int[]{1,2,4,4,3}));
        System.out.println(new candy_按分数和位置分糖果().candy(new int[]{2,1}));
    }
}
