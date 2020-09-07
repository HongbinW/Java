package Zuo100.c5;

import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2019/10/27
 */
//思路：窗口最大最小更新模型。以L开头能到达的最远位置
//tips：如果一个数组的max - min <= num，则其子数组的max - min <= num
public class Q2_countSubArray_求子数组最大值与最小值差值小于num的情况 {
    //未OJ
    public static int countSubArray(int[] arr, int num){
        if (arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> maxList = new LinkedList<>();
        LinkedList<Integer> minList = new LinkedList<>();
        int L = 0, R = 0;
        int res = 0;
        while (L < arr.length){
            while (R < arr.length) {
                while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[R]) {   //记录坐标，保证从左到右，从大到小
                    maxList.pollLast();
                }
                maxList.addLast(R);
                while (!minList.isEmpty() && arr[minList.peekLast()] >= arr[R]) {   //记录坐标，保证从左到右，从小到大
                    minList.pollLast();
                }
                minList.addLast(R);
                if (maxList.peekFirst() - minList.peekFirst() > num){   // 如果超了，说明，从L开始，到这个位置之后的都不行了，即当前R不满足，这里之所以没做-1操作，是跟下面res需要R-L+1抵消了
                    break;
                }
                R ++;
            }
            res += R - L;       // 以这个位置开始的所有子数组
            if (maxList.peekFirst() == L){      //检查头部是否过期
                maxList.pollFirst();
            }
            if (minList.peekFirst() == L){
                minList.pollFirst();
            }
            L ++;
        }
        return res;
    }
}
