package JZOffer.C_codeIntegrity;

/**
 * @Author: HongbinW
 * @Date: 2019/4/3 11:17
 * @Version 1.0
 * @Description:
 * 可进一步考虑可拓展性，即把判断奇偶数的函数抽象出来
 */
public class M20_reOrderArray {
    public static void reOrderArray(int [] array){
        if(array == null || array.length < 2){
            return;
        }
        int p1 = 0;
        int p2 = array.length-1;
        while(p1>p2){
            while(p1 % 2 !=0){  //p1来找偶数
                p1++;
            }
            while(p2 % 2 == 0){ //p2来找奇数
                p2--;
            }
            swap(array,p1,p2);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
