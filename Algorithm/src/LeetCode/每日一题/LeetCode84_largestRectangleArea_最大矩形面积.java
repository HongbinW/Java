package LeetCode.每日一题;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/30
 */

// 单调栈。每个位置向两头找能到的最远距离。 从小到大
// 因为是从小到大，因此最右位置不变，不断去找当前数的最小位置。
// 且求得是面积，因此为了求宽度，应保存下标，而不是高度。
public class LeetCode84_largestRectangleArea_最大矩形面积 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0 ; i < heights.length; i ++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int cur = stack.pop();
                int next = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, heights[cur] * (i - next - 1));
            }
            stack.push(i);
        }
        int maxIndex = stack.peek();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            int next = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, heights[cur] * (maxIndex - next));
        }
        return res;
    }
}
