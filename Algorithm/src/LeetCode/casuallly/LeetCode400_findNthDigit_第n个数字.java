package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/20
 */
public class LeetCode400_findNthDigit_第n个数字 {
    public int findNthDigit(int n) {
        // 看第n个数字在哪个范围
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.   找到n的位数
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;  //当前阶段的个数
        }
        long num = start + (n - 1) / digit; // 2.   start表示这个阶段的开始，n-1/digit表示当前这个阶段剩余的这块对应的实际数字
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.  确定这个数要输出第几位  n-1%digit 表示剩余的这些个数要输出第几个。
        // 换成数组更方便表示第几位
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode400_findNthDigit_第n个数字().findNthDigit(192));
    }
}
