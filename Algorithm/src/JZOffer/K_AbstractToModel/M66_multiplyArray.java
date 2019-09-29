package JZOffer.K_AbstractToModel;

/**
 * @Author: HongbinW
 * @Date: 2019/9/15 21:27
 * @Version 1.0
 * @Description:
 */
public class M66_multiplyArray {
    public static int[] mutiplyArray(int[] arr){
        int[] left = new int[arr.length];
        left[0] = 1;
        for (int i = 1; i < arr.length; i ++){
            left[i] = left[i-1] * arr[i-1];
        }
        int[] right = new int[arr.length];
        right[arr.length-1] = 1;
        for (int i = arr.length-2; i >= 0; i --){
            right[i] = right[i+1] * arr[i+1];
        }
        for (int i = 0; i < arr.length; i ++){
            left[i] *= right[i];
        }
        return left;
    }

    public static void main(String[] args) {
        for (int i : mutiplyArray(new int[]{1,2,3,4,5})){
            System.out.print(i + " ");
        }
    }
}
