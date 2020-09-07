package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/21
 */
public class LeetCode1306_canReach_跳跃游戏三_能否跳到每一个为0的位置 {
    public boolean canReach(int[] arr, int start) {
        boolean[] flag = new boolean[arr.length];
        return process(flag,arr,start);
    }
    public boolean process(boolean[] flag, int[] arr, int start){
        if (start >= arr.length || start < 0 || flag[start]){
            return false;
        }
        if (arr[start] == 0){
            return true;
        }
        flag[start] = true;
        return process(flag,arr,start+arr[start]) || process(flag,arr,start-arr[start]);
    }
}
