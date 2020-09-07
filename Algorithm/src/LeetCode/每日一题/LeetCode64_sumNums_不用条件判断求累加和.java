package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/2
 */
public class LeetCode64_sumNums_不用条件判断求累加和 {
    public static void main(String[] args) {
        System.out.println(sumNums(4));
    }
    public static int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n-1)) > 0;
        return n;
    }
}
