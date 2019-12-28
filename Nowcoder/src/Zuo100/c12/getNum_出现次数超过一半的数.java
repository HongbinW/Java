package Zuo100.c12;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/19
 */
public class getNum_出现次数超过一半的数 {
    public static int getNum(int[] arr){
        if (arr == null || arr.length == 0){
            return -10086;
        }
        int candidate = arr[0];
        int times = 1;
        for (int i = 1; i < arr.length; i ++){
            if (times == 0){
                candidate = arr[i];
                times = 1;
            }else if (arr[i] == candidate){
                times ++;
            }else{
                times --;
            }
        }
        times = 0;
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == candidate){
                times ++;
            }
        }
        return times > arr.length / 2 ? candidate : -10086;
    }

    public static void main(String[] args) {
        System.out.println(getNum(new int[]{1,2,3,4,5}));
    }
}
