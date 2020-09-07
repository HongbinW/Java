package LeetCode.casuallly;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/7
 */
public class LeetCode503_nextGreaterElements_循环数组每个位置下一个最大的元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1};
        int[] res = nextGreaterElements(arr);
        for (int i : res){
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
    public static int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();   // 记录位置  nums从大到小
        int index = 0;
        int tail = -1;      // 记录栈底元素位置
        while (index < nums.length){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]){
                res[stack.pop()] = nums[index];
            }
            if (stack.isEmpty()){   // 如果空了，则更新栈底元素
                tail = index;
            }
            stack.push(index++);
        }
        if (stack.isEmpty()){
            return res;
        }
        index = 0;
        while (index < tail){       // 从0至栈底位置的再全压进来
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]){
                res[stack.pop()] = nums[index];
            }
            stack.push(index ++);
        }
        while (!stack.isEmpty()){   // 栈底元素结果为-1，他上面的因为是从大到小的，所以这些位置的下一个最大位置都是栈底元素
            int cur = stack.pop();
            if (nums[cur] < nums[tail])
                res[cur] = nums[tail];
            else{
                res[cur] = -1;
            }
        }
        return res;
    }
}
