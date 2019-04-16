package LeetCode.springContest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Author: HongbinW
 * @Date: 2019/4/14 17:05
 * @Version 1.0
 * @Description:
 * 给定一系列价格 [p1,p2...,pn] 和一个目标 target，将每个价格 pi 舍入为 Roundi(pi) 以使得舍入数组 [Round1(p1),Round2(p2)...,Roundn(pn)] 之和达到给定的目标值 target。每次舍入操作 Roundi(pi) 可以是向下舍 Floor(pi) 也可以是向上入 Ceil(pi)。
 *
 * 如果舍入数组之和无论如何都无法达到目标值 target，就返回 -1。否则，以保留到小数点后三位的字符串格式返回最小的舍入误差，其定义为 Σ |Roundi(pi) - (pi)|（ i 从 1 到 n ）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prices = ["0.700","2.800","4.900"], target = 8
 * 输出："1.000"
 * 解释：
 * 使用 Floor，Ceil 和 Ceil 操作得到 (0.7 - 0) + (3 - 2.8) + (5 - 4.9) = 0.7 + 0.2 + 0.1 = 1.0 。
 * 示例 2：
 *
 * 输入：prices = ["1.500","2.500","3.500"], target = 10
 * 输出："-1"
 * 解释：
 * 达到目标是不可能的。
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 500
 * 表示价格的每个字符串 prices[i] 都代表一个介于 0 和 1000 之间的实数，并且正好有 3 个小数位。
 * target 介于 0 和 1000000 之间
 */
public class Q3_minimizeError {
    public static String minimizeError(String[] prices, int target) {
        double[] source = new double[prices.length];
        for(int i = 0; i < prices.length; i++){
            source[i] = Double.valueOf(prices[i]);
        }
        int[][] arr = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            arr[i][0] = (int)Math.floor(source[i]);
            arr[i][1] = (int)Math.ceil(source[i]);
        }
        int sum = 0;
        for(int i = 0; i < prices.length; i++){
            sum += arr[i][1];
        }
        int count = 0;
        for(int i = 0; i < prices.length; i++){
            if(arr[i][0] == arr[i][1])
                count++;
        }
        if(sum == target && count == prices.length){
            return "0.000";
        }
        int diff = sum - target - count;        //比target多了多少，多几个，就有几个选floor
        if(diff < 0 || diff > prices.length)
            return "-1";

        double[] diffloor = new double[prices.length];
        double[] difceil = new double[prices.length];
        for (int i = 0; i < prices.length; i++){
//            difmin[i] = Math.min(Math.abs(arr[i][0] - source[i]),Math.abs(arr[i][1]-source[i]));
            diffloor[i] = Math.abs(arr[i][0] - source[i]);
            difceil[i] = Math.abs(arr[i][1] - source[i]);
        }
        Arrays.sort(diffloor);
        Arrays.sort(difceil);
        double res = 0;
        TreeMap<Double,Integer> map = new TreeMap<>();
        for(int i = 0; i < diff; i++){
            res += diffloor[i];
            if(!map.containsKey(diffloor[i])){
                map.put(diffloor[i],0);
            }
            map.put(diffloor[i],map.get(diffloor[i])+1);
        }
        for(int i = 0; i < prices.length-diff; i++){
            if(map.containsKey(1-difceil[i])){
                int temp = map.get(1-difceil[i]);
                map.put(1-difceil[i],map.get(1-difceil[i])-1);
                continue;
            }
            res += difceil[i];

        }
        DecimalFormat df = new DecimalFormat( "0.000");
        return df.format(res);
    }

    public static void main(String[] args) {
        String[] prices = new String[]{"2.0","2.0","2.0","2.0","2.0"};
        int target = 10;
        System.out.println(minimizeError(prices,target));
    }
}
