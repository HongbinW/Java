package examination.浪潮;

import java.util.HashMap;
import java.util.Scanner;

public class Main1_移动到最左边和最后边_求最少移动次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println(process(arr));
    }
    public static int process(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i ++){
            if (map.containsKey(arr[i] - 1)){
                map.put(arr[i],map.get(arr[i]-1)+1);
            }else{
                map.put(arr[i],1);
            }
            max = Math.max(max,map.get(arr[i]));
        }
        return arr.length - max;
    }
}