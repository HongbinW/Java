package examination.tencent.nowcoder2017_summer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i ++){
                arr[i] = sc.nextInt();
            }
            process(arr);
        }
    }
    private static void process(int[] arr){
        int minDiff = Integer.MAX_VALUE;
        int minCount = 1;
        int resMinCount = 0;
        boolean flag = true;
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i ++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i]) + 1);
                flag = false;
            }
            if (flag && i > 0){
                int temp = arr[i] - arr[i-1];
                    if (temp < minDiff){
                        minDiff = temp;
                        resMinCount = Math.max(resMinCount,minCount);
                        minCount = 1;
                    }else if (temp == minDiff){
                        minCount ++;
                    }
            }
        }
        if (!flag){
            resMinCount = 0;
            for (int i : map.keySet()){
                int temp = map.get(i);
                if (temp > 1){
                    resMinCount += temp * (temp - 1) / 2;
                }
            }
        }else {
            resMinCount = Math.max(resMinCount, minCount);
        }
        int left = 0;
        int index = 0;
        while (index < arr.length && arr[index] == arr[0]){
            left ++;
            index ++;
        }
        int right = 0;
        index = arr.length - 1;
        while (index >= 0 && arr[index] == arr[arr.length - 1]){
            right++;
            index --;
        }
        int resMaxCount = left * right;
        System.out.println(resMinCount + " " + resMaxCount);
    }
}
