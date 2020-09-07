package LeetCode.每日一题;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/11
 */
public class LeetCode739_dailyTemperatures_每日温度 {
    class Solution {

        Stack<Node> stack = new Stack<Node>();

        public int[] dailyTemperatures(int[] T) {

            if(T == null || T.length == 0) {
                return null;
            }

            int[] dayCountRecord = new int[T.length];
            for(int indexOfTemp = 0; indexOfTemp < T.length; indexOfTemp++) {
                int todaysTemp = T[indexOfTemp];
                if(stack.empty()) {
                    stack.push(new Node(indexOfTemp, todaysTemp));
                    continue;
                }
                while(!stack.empty() && todaysTemp > stack.peek().temperature) {
                    Node latest = stack.pop();
                    dayCountRecord[latest.indexOfTemp] = indexOfTemp - latest.indexOfTemp;
                }

                stack.push(new Node(indexOfTemp, todaysTemp));
            }
            return dayCountRecord;
        }

        class Node {
            int indexOfTemp;
            int temperature;
            public Node(int indexOfTemp, int temperature) {
                this.indexOfTemp = indexOfTemp;
                this.temperature = temperature;
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[]{89,62,70,58,47,47,46,76,100,70};
        dailyTemperatures(arr);
    }
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int[] arr = new int[70];
        arr[T[T.length-1]-30] = T.length-1;
        for(int i = T.length - 2; i >= 0; i --){
            int step = 30001;
            for (int j = T[i] - 30 + 1; j <= 70; j ++){
                if (arr[j] != 0){
                    step = Math.min(step,arr[j] - i);
                }
            }
            res[i] = step;
            arr[T[i]-30] = i;
        }
        return res;
    }
}
