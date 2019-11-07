package nowcode.LeetCode;

public class singleNumber_一个只出现一次其余三次 {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i ++){
            int tmp = 0;
            for (int j = 0; j < A.length; j ++){
                tmp += (A[j] >>> i) & 1;
            }
            if (tmp % 3 != 0){
                res += ((tmp%3) << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new singleNumber_一个只出现一次其余三次().singleNumber(new int[]{1,2,3,4,2,1,3,1,2,3}));
    }
}
