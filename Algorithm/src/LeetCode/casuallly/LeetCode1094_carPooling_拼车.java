package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/21
 */
public class LeetCode1094_carPooling_拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int i = 0; i < trips.length; i ++){
            for (int j = trips[i][1]; j < trips[i][2]; j ++){
                arr[j] += trips[i][0];
                if (arr[j] > capacity){
                    return false;
                }
            }
        }
        return true;
    }

    // 更优解
    public boolean carPooling2(int[][] trips, int capacity) {
        int[] capacityThroughRoad = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int currentNum = trips[i][0];
            capacityThroughRoad[trips[i][1]] -= currentNum;     //上车减
            capacityThroughRoad[trips[i][2]] += currentNum;     //下车加
        }

        for (int change: capacityThroughRoad) {
            capacity += change;                 // 累加变化
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
