package nowcode.high_frequency;

/**
 * Description
 * Author  HongbinW
 * Date 2020/4/14
 */
//牛牛有两个长度为nn的数组a, ba,b，牛牛希望统计有多少数对(l, r)(l,r)满足：
//1，0 <= l <= r <= n - 1
//2，∑i=l->r(ai) = bl + br

public class countLR_满足LR的对数 {
    public static void main(String[] args) {
        System.out.println(countLR(new int[]{0,0,1,1,1},new int[]{2,0,4,3,3}));
    }
    public static int countLR (int[] a, int[] b) {
        int count = 0;
        for(int i = 0; i < a.length; i ++){
            int ai = 0;
            for (int j = i; j < b.length; j ++){
                ai += a[j];
                int bi = b[i]+b[j];
                if (bi == ai){
                    count ++;
                }
            }
        }
        return count;
    }
}
