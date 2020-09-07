package LeetCode.会员.大疆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/16
 */
public class LeetCode869_reorderedPowerOf2_重新排序得到2的幂 {
    public static void main(String[] args) {
        System.out.println(new LeetCode869_reorderedPowerOf2_重新排序得到2的幂().reorderedPowerOf2(46));
    }
    public boolean reorderedPowerOf2(int N) {
        int[] arr = new int[10];
        List<Integer> list = find2Power(N);
        while (N > 0){
            arr[N%10] ++;
            N /= 10;
        }
        for (int i = 0; i < list.size(); i ++){
            int[] compare = Arrays.copyOf(arr,arr.length);
            int target = list.get(i);
            while (target > 0){
                compare[target%10] --;
                if (compare[target%10] < 0){
                    break;
                }
                target /= 10;
            }
            int j = 0;
            for (; j < compare.length; j ++){
                if (compare[j] != 0){
                    break;
                }
            }
            if (j == compare.length){
                return true;
            }
        }
        return false;
    }
    public List<Integer> find2Power(int N){
        int digit = 0;
        int cur = N;
        while (cur > 0){
            digit ++;
            cur /= 10;
        }
        int base = (int)Math.pow(10,digit-1);
        cur = 1;
        while (cur < base){
            cur *= 2;
        }
        List<Integer> list = new ArrayList<>();
        while (cur < base * 10){
            list.add(cur);
            cur *= 2;
        }
        return list;
    }
}
