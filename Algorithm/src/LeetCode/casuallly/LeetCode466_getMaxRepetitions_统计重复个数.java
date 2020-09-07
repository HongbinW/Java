package LeetCode.casuallly;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2020/4/19
 */
public class LeetCode466_getMaxRepetitions_统计重复个数 {
    public static void main(String[] args) {
        System.out.println();
    }
    //整体思路：找循环节。在s1中找s2的循环节
    public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        if (n1 == 0){
            return 0;
        }
        char[] c1 = s1.toCharArray();       //事实证明，这种方式速度更快
        char[] c2 = s2.toCharArray();
        int l1 = s1.length();
        int l2 = s2.length();
        int count1 = 0; //记录到目前为止，经历了多少s1
        int count2 = 0; //记录到目前为止，经历了多少s2
        HashMap<Integer,int[]> map = new HashMap<>();   //记录每次遍历完s1时，s2的位置所对应的count1和count2.当出现过p，说明这块跟上一次称为一个循环了，这个循环中有固定的s1和固定的s2
        int p = 0;  //s2当前的位置
        while (count1 < n1){
            for (int i = 0; i < l1; i ++){
                if (c1[i] == c2[p]){
                    p ++;
                }
                if (p == l2){
                    p = 0;
                    count2 ++;
                }
            }
            count1 ++;
            if (!map.containsKey(p)){
                map.put(p,new int[]{count1,count2});
            }else{
                int[] pre = map.get(p); //当前count1-上次count1，即这段循环中包含的s1个数
                int circle1 = count1 - pre[0];
                int circle2 = count2 - pre[1];
                count2 += (n1 - count1) / circle1 * circle2;    //剩下这部分中的循环体个数为(n1 - count1) / circle1，那么其中包含的s2个数就再*circle2
                count1 = count1 + (n1-count1) / circle1 * circle1;  //跳过这块循环体
            }
        }
        return count2 / n2;
    }
}
