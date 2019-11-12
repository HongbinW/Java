package nowcode.LeetCode.easy;

public class singleNumber_一个出现一次其余两次 {
    public int singleNumber(int[] A) {
        int res = A[0];
        for (int i = 1; i < A.length; i ++){
            res ^= A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new singleNumber_一个出现一次其余两次().singleNumber(new int[]{1,4,2,3,1,3,2}));
    }
}
