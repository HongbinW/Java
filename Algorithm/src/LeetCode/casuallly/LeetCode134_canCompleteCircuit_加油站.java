package LeetCode.casuallly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/21
 */
public class LeetCode134_canCompleteCircuit_加油站 {
    public int canComplete(int[] gas, int[] cost){
        int n = gas.length;
        int sumTank = 0;//总油量
        int curTank = 0;//当前油箱内的油量
        int startStation = 0;
        for(int i = 0; i < n;i++){
            sumTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if(curTank < 0){        //如果不够了，那就从下一个加油站开始
                startStation = i + 1;
                curTank = 0;
            }
        }
        return sumTank >= 0 ? startStation : -1;    // 能否跑完一圈
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] diff = new int[len];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; i ++) {
            diff[i] = gas[i] - cost[i];
            if (diff[i] > 0) {
                list.add(i);
            }
        }
        while (!list.isEmpty()){
            int index = list.poll();
            int start = index;
            int cur = diff[index++];
            while (index % len != start){
                cur += diff[index % len];
                if(cur < 0){
                    break;
                }
                index ++;
            }
            if (start == index % len){
                return start;
            }
        }
        return -1;
    }
}
