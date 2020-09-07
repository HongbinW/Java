package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/21
 */
public class Q62_lastRemaining_圆圈中最后剩下的数字_约瑟夫环 {
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;       // n=1时，因为只有一个数0，所以返回0
        for (int i = 2; i <= n; i ++){
            last = (last + m) % i;
            // 关键：f(n,m) = (m + x) % n。 其中x是f(n-1,m)剩下的那个数，即如果是从0-n-2剩下了第m个，
            // 那么对于0-n-1这个n个数，首先去掉m%n，此时也剩下了n-1个数，所以相对f(n-1,m)剩下了第m+x

            // 所以让last一直保存上一次剩下的那个数
        }
        return last;
    }
}
