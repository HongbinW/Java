/**
 * @Author: HongbinW
 * @Date: 2019/4/2 19:37
 * @Version 1.0
 * @Description:
 */

import java.util.ArrayList;
import java.util.Arrays;

/*给定一个数组，从其中选取三个数，要求三个数的和必须是0，求出所有这样的组合
 * dfs超时，但是方法扩展性强，可扩展到四个数、五个数的和是0；
 * 先固定一个，再利用双指针求解的方法不会超时
 */
public class ThreeSum {
    public int threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length <= 0)
            return 0;
        Arrays.sort(num);
        for(int i = 0;i < num.length - 2;i ++) {
            //保证不要出现值相同的起点，避免重复搜索
            if(i == 0 || num[i] > num[i - 1]) {
                for(int j = i + 1; j < num.length; j++) {
                    for (int k = num.length - 1; k > j; k--) {
                        if (maxGcd2(num[i], num[j], num[k]) == 1) {
                            ArrayList<Integer> temp = new ArrayList<Integer>();
                            temp.add(num[i]);
                            temp.add(num[j]);
                            temp.add(num[k]);
                            if (!res.contains(temp))
                                res.add(temp);
                        }
                    }
                }
            }
        }
        return res.size();
    }

    public static void main(String[] args) {

        int[] num = {1,2,3,4,5,6,7,8};
        System.out.println(new ThreeSum().threeSum2(num));
//        System.out.println(maxGcd2(36,30,24));
    }


    public static int maxGcd4(int a, int b) {
        int i = a % b;
        int max_gcd = 1;
        if (i == 0) {
            max_gcd = b;
            //System.out.println(max_gcd);
        } else {
            a = b;
            b = i;
            max_gcd = maxGcd4(a, b);
        }
        return max_gcd;

    }
    public static int maxGcd2(int a, int b, int c) {
        int d = maxGcd4(a, b);
        int i = c % d;
        int max_gcd = 1;
        if (i == 0) {
            max_gcd = d;
        } else {
            c = maxGcd4(a, b);
            d = i;
            max_gcd = maxGcd4(c, d);
        }
        return max_gcd;
    }
    public static int Count(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            if(maxGcd2(nums[i],nums[j],nums[k]) == 1){

            }
        }
        return 0;
    }
}

