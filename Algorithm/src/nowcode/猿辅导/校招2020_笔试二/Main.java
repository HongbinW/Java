package nowcode.猿辅导.校招2020_笔试二;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/19
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        process(arr, m);
    }
    public static void process(int[] arr, int m){
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i ++){
            if (countMap.containsKey(arr[i])){
                countMap.put(arr[i], countMap.get(arr[i])+1);
            }else{
                countMap.put(arr[i], 1);
            }
        }
        for (int i = 0; i < arr.length; i ++){
            if (countMap.get(arr[i]) > m){
                continue;
            }else{
                System.out.printf("%d ", arr[i]);
            }
        }
    }
}
