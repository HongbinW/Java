package Zuo100.c7;

import com.sun.org.apache.regexp.internal.RE;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/3
 */
//要求给出1-n个棋子在一个格子里的最少移动次数
    /*
    思路：可能的位置只有(a1,b1)(a1,b2)(a1,b3)(a1,b4)
                        (a2,b2)(a2,b2)(a3,b2)(a4,b2)
                        ...
                        ...
          因此每个位置做一个小根堆，存放的是每个实际点到该点的曼哈顿距离，需要多少个棋子就pop几次，然后求最小值。
     */
public class Q2_minStepsMove_棋子移动最少次数 {
    public void minStepsMove(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int size = sc.nextInt();
            int[] x = new int[size];
            int[] y = new int[size];
            for (int i = 0; i < size; i ++){
                x[i] = sc.nextInt();
            }
            for (int i = 0; i < size; i ++){
                y[i] = sc.nextInt();
            }
            int[] res = minSteps(x,y);
            for (int i = 0; i < res.length; i ++){
                System.out.printf("至少有一个格子中至少有%d个棋子要操作的次数最少为%d次\n", i+1, res[i]);
            }
        }
    }

    public int[] minSteps(int[] x, int[] y){
        int[] res = new int[x.length];
        for (int i = 0; i < x.length; i ++){
            res[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < x.length; i ++){
            for (int j = 0; j < y.length; j ++){
                for (int k = 0; k < x.length; k ++){
                    pq.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
                }
                int num = 0;
                int temp = 0;   //当前位置有num+1个棋子要移动的次数
                while (!pq.isEmpty()) {
                    temp += pq.poll();
                    res[num] = Math.min(res[num],temp);
                    num ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Q2_minStepsMove_棋子移动最少次数().minStepsMove();
    }
}
