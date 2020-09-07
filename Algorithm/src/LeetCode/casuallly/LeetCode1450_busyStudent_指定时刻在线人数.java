package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/7
 */
public class LeetCode1450_busyStudent_指定时刻在线人数 {
    public static void main(String[] args) {
        int[] startTime = new int[]{4};
        int[] endTime = new int[]{4};
        System.out.println(busyStudent(startTime,endTime,4));
    }
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] arr = new int[queryTime+1];
        for (int i = 0; i < startTime.length; i ++){
            if (startTime[i] <= queryTime){
                arr[startTime[i]] ++;
            }
            if (endTime[i] <= queryTime){
                arr[endTime[i]] --;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i ++){
            res += arr[i];
        }
        return res;
    }
}
