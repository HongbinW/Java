package LeetCode.面试题系列;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/28
 */
public class m8_1_waysToStep_上台阶1_3步 {
    public int waysToStep(int n) {
        if (n < 3){
            return n;
        }else if (n == 3){
            return 4;
        }else{
            return waysToStep(n-1) + waysToStep(n-2) + waysToStep(n - 3);
        }
    }

    public int waysToStep2(int n) {
        if (n < 4) {
            return n == 3 ? 4 : n;
        }

        int a = 1, b = 2, c = 4;
        for (int i = 4; i <= n; ++i) {
            int temp = (a + b) % 1000000007 + c;
            a = b;
            b = c;
            c = temp % 1000000007;
        }
        return c;
    }
}
