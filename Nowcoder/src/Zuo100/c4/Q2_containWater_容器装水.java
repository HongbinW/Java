package Zuo100.c4;

/**
 * 思路：找每个位置向左和向右的最大值，取二者的较小者，与当前位置的高度进行比较，超过则累加，不过则跳过
 */
public class Q2_containWater_容器装水 {
    //  O(N)   O(N)
    public static int maxWater(int[] arr){
        if (arr == null || arr.length < 3){
            return 0;
        }
        int[] help = new int[arr.length];
        help[0] = arr[0];
        for (int i = 1; i < help.length; i ++){ //记录每个位置向左的最大值
            help[i] = arr[i] > help[i-1] ? arr[i] : help[i-1];
        }
        int cur = arr[arr.length - 1];
        help[arr.length - 1] = Math.min(cur,help[arr.length-1]);
        for (int i = help.length - 2; i >= 0; i --){
            cur = Math.max(cur,arr[i]);     //每个位置向右的最大值
            help[i] = Math.min(help[i],cur);    //取二者最小值
        }
        int res = 0;
        for (int i = 1; i < arr.length - 1; i ++){
            if (arr[i] > help[i]){
                continue;
            }else{
                res += help[i] - arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxWater2(new int[]{3,1,2,4}));
    }

    //  O(N)    O(1)
    public static int maxWater2(int[] arr){
         int lMax = arr[0];
         int rMax = arr[arr.length - 1];    //最两边的不能装水
         int left = 1;
         int right = arr.length - 2;
         int res = 0;
         while (left <= right){
             if (lMax > rMax){
                 if (arr[right] < rMax){
                     res += (rMax - arr[right]);
                 }else{
                     rMax = arr[right];
                 }
                 right --;
             }else{
                 if (arr[left] < lMax){
                     res += (lMax - arr[left]);
                 }else{
                     lMax = arr[left];
                 }
                 left ++;
             }
         }
         return res;
    }
}
