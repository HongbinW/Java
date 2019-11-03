package Zuo100.c5;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2019/9/30
 */
//思路:首先以每一行为底，向上连续为1的高度
//然后，求以每个位置向左和向右能拓展的最远边界    ——>单调栈
public class Q1_maxRect_最大矩形区域 {
    public static int singleStack(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < arr.length; i ++){
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                int j = stack.pop();    // 一定要先pop再peek，否则可能出现不了empty
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * arr[j];
                res = Math.max(res, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j = stack.peek();
            int k = stack.isEmpty() ? -1 : stack.pop();
            int curArea = (arr.length - k - 1) * arr[j];
            res = Math.max(curArea,res);
        }
        return res;
    }
    public static int maxRect(int[][] matrix){
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int[] help = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i ++){       //以每一行为底
            for (int j = 0; j < help.length; j ++){
                if (matrix[i][j] == 1){
                    help[j] ++;
                }else{
                    help[j] = 0;
                }
            }
            res = Math.max(res,singleStack(help));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,0}
        };
        System.out.println(maxRect(matrix));
    }
}
