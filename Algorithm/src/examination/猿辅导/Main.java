package examination.猿辅导;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/1
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        ArrayList<int[]> list = new ArrayList<>();
        while (N > 0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new int[]{start, end});
            N --;
            min = Math.min(min,start);
            max = Math.max(max, end);
        }
        int[] arr = new int[max-min+2];
        for(int i = 0; i < list.size(); i ++){
            arr[list.get(i)[0] + 1 - min] ++;
            arr[list.get(i)[1] + 1 - min] --;
        }
        int res = 0;
        int cur = 0;
        for (int i = 0; i < arr.length; i ++){
            cur += arr[i];
            res = Math.max(res, cur);
        }
        System.out.println(res);
    }
}
