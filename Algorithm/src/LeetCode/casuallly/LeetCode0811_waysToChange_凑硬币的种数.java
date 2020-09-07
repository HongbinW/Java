package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/4/23
 */
public class LeetCode0811_waysToChange_凑硬币的种数 {
    public static void main(String[] args) {
        System.out.println(waysToChange(200));
    }
    public static int waysToChange(int n) {
        int[] arr = new int[26];
        for(int i = 1; i <= n; i ++){
            if(i - 1 >= 1){
                arr[i%26] = 1;
            }
            if(i - 5 >= 0){
                arr[i%26] += arr[(i-5)%26] % 1000000007;
                arr[i%26] = arr[i%26] % 1000000007;
            }
            if(i - 10 >= 0){
                arr[i%26] += arr[(i-10)%26] % 1000000007;
                arr[i%26] = arr[i%26] % 1000000007;
            }
            if(i - 25 >= 0){
                arr[i%26] += arr[(i-25)%26] % 1000000007;
                arr[i%26] = arr[i%26] % 1000000007;
            }
            if(i == 1 || i == 5 || i == 10 || i == 25){
                arr[i%26] ++;
                arr[i%26] = arr[i%26] % 1000000007;
            }
        }
        return arr[n%26] % 1000000007;
    }
    public static int waysToChange2(int n) {
        int count10 = 0, count5 = 0, count25 = 0;
        int res = 1;
        for (int i = 0; i < 3; i ++) {
            int cur = n;
            if (i == 0 && cur < 25 || i == 1 && cur < 10 || i == 2 && cur < 5){
                continue;
            }
            if (i < 1 && cur > 25){
                count25 = cur / 25;
                cur %= 25;
            }
            if (i < 2 && cur / 10 > 0){
                count10 = cur / 10;
                cur %= 10;
            }
            if (i < 3 && cur / 5 > 0){
                count5 = cur / 5;
                cur %= 5;
            }
            int count = count5 % 1000000007 + count10 % 1000000007 + count25 % 1000000007;
            if (count > 1){
                res += count;
            }
            res = res % 1000000007;
        }
        return res;
    }
}
