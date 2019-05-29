package JZOffer.H_timeEfficiency;

public class M42_FindGreatestSumOfSubArray {
    //法一:
    public static int FindGreatestSumOfSubArray(int[] array) {
        int curMax = 0;
        int res = 0;
        for (int i = 0; i < array.length; i++){
            curMax = curMax + array[i] < array[i] ? array[i] : curMax + array[i];
            res = res < curMax ? curMax : res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }
}
