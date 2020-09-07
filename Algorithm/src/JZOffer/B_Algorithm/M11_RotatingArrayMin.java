package JZOffer.B_Algorithm;

/**
 * @Author: HongbinW
 * @Date: 2019/3/17 9:16
 * @Version 1.0
 */
public class M11_RotatingArrayMin {
    public static int RotatingArrayMin(int[] arr){
        if(arr == null || arr.length < 1){
            throw new IllegalArgumentException("Illegal Argument.");
        }
        int p1 = 0;     //p1一直指向的是第一段递增数组的元素
        int p2 = arr.length - 1;    //p2一直指向的是第二段递增数组的元素
        int mid = p1;
        while(arr[p1] >= arr[p2]){      //前一段数组的值一定大于等于后一段数组的值
                                        //并且这样可以防止已排序好的数组
            if(p1+1 == p2){
                mid = p2;
                break;
            }

            mid = p1 + (p2 - p1) / 2;

            if(arr[p1] == arr[mid] && arr[p2] == arr[mid]){
                int min = arr[p1];
                for(int i = p1 + 1; i < arr.length; i++){
                    if(min > arr[i]){
                        min = arr[i];
                    }
                }
                return min;
            }
            if(arr[mid] >= arr[p1]){
                p1 = mid;
            }else if(arr[mid] <= arr[p2]){
                p2 = mid;
            }

        }
        return arr[mid];
    }

    public static int method2(int[] array){
        int len = array.length;
        if(len == 0)
            return 0;
        int low = 0, high = len - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){   //说明肯定有旋转的数组，且
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,2,1,1,1};
        System.out.println(RotatingArrayMin(arr));
        System.out.println(method2(arr));
    }
}
