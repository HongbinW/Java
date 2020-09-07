package examination.ByteDance.提前批_一面;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/1
 */
public class 找最大值 {
        public static void main(String[] args) {
            System.out.println(process(new int[]{1,2,3,4,5,6,7,8,5,3,2,1}));
        }
        public static int process(int[] arr){
            int left = 0;
            int right = arr.length - 1;
            while(left < right){
                int mid = left + (right - left) / 2;
//            if(mid == left){
//                return Math.max(arr[mid],arr[mid+1]);
//            }
                if(arr[mid] < arr[mid + 1]){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            return arr[left];
        }

}
