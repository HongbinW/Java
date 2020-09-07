package LeetCode.每日一题;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/17
 */
public class LeetCode1014_maxScoreSightseeingPair_最佳观光组合 {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{6,9,10,5,9,10,4,5}));
    }

    // A[i]+i 不断变化, A[j]-j是不变的，即到哪个位置就算到哪
    // 因此只需要维护A[i]+i即可。
    public int maxScoreSightseeingPair3(int[] A) {
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }


    // My solution 单调栈，也过了，但是时间复杂度似乎不是很好
    public static int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        if (A == null || A.length < 2){
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i ++){
            if (stack.isEmpty() || A[stack.peek()] >= A[i]){
                stack.push(i);
            }else{
                while (!stack.isEmpty() && A[stack.peek()] < A[i]){
                    int curIndex = stack.pop();
                    res = Math.max(res, A[i] + A[curIndex] + curIndex - i);
                    if(!stack.isEmpty()) {
                        res = Math.max(res, A[stack.peek()] + A[curIndex] + stack.peek() - curIndex);
                    }
                }
                stack.push(i);
            }
        }
        while (stack.size() > 1){
            int curIndex = stack.pop();
            res = Math.max(res, A[stack.peek()] + A[curIndex] + stack.peek() - curIndex);
        }
        return res;
    }


}
