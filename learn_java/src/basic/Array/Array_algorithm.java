package basic.Array;
//1.求数组元素的最大值、最小值、平均数、总和等
//
//        2.数组的复制、反转
//
//        3.数组元素的排序 见ArraySort

public class Array_algorithm {
    public static void main(String[] args){
        int[] arr = new int[]{12,43,9,0,-65,-99,100,9};

        //max
        int max = arr[0];
        for(int i = 0;i < arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("数组的最大值为"+max);

        //min
        int min = arr[0];
        for(int i = 0;i < arr.length;i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("数组的最小值为"+min);

        //sum
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            sum += arr[i];
        }
        System.out.println("数组的和为"+sum);

        //average
        int avg = 0;
        avg = sum/arr.length;
        System.out.println("平均值为"+avg);

        //数组复制
            //见Eg5
        int[] arr1 = new int[arr.length];
        for(int i = 0;i < arr1.length;i++){
            arr1[i] = arr[i];
        }
        //数组元素的反转
        int ls;
        for (int i = 0;i <= arr.length / 2 ;i++) {
            ls = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = ls;
        }
        //遍历
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
