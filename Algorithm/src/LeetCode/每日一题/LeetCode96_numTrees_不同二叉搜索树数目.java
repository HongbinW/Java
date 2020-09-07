package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/15
 */
public class LeetCode96_numTrees_不同二叉搜索树数目 {
    public static void main(String[] args) {
        System.out.println(new LeetCode96_numTrees_不同二叉搜索树数目().numTrees(4));
    }
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
