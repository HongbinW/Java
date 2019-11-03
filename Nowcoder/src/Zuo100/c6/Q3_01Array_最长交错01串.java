package Zuo100.c6;

/**
 * Description
 * Author  HongbinW
 * Date 2019/10/28
 */
public class Q3_01Array_最长交错01串 {
    public static int maxLength01Array(int[] arr){
        int cur = 1;
        int res = 0;
        for (int i = 1; i < arr.length; i ++){
            if (arr[i] != arr[i-1]){
                cur ++;
                res = Math.max(cur,res);
            }else{
                cur = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxLength01Array(new int[]{1,0,1,0,0,1,0}));
    }
}
