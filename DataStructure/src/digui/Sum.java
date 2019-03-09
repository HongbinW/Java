package digui;

public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr,int l) {
        if (l == arr.length) {      //求解最基本问题
            return 0;
        }
        return arr[l] + sum(arr,l + 1);     //吧原问题转化成更小的问题
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }
}
