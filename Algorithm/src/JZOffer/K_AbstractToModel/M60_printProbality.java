package JZOffer.K_AbstractToModel;

/**
 * @Author: HongbinW
 * @Date: 2019/9/8 21:39
 * @Version 1.0
 * @Description:
 */
public class M60_printProbality {
    public static void process(int n){
        int[][] arr = new int[2][6 * n + 1];    //第n个位置，表示n出现的次数
        for (int i = 1; i <= 6; i ++){
            arr[0][i] = 1;
        }
        int flag = 0;
        for (int i = 2; i <= n; i ++){  //当前第几个筛子
            for (int j = 0; j < i; j ++){
                arr[1-flag][j] = 0;
            }
            for (int j = i; j <= i * 6; j ++){  //当前最小数为骰子数i
                for (int m = 1; m <= 6 && m <= j; m ++){
                    arr[1-flag][j] += arr[flag][j-m];   //每次根据当前数组处理另一个数组（下一次用的数组）
                }
            }
            flag = 1 - flag;
        }
        double count = Math.pow(6,n);
        for (int i = 6; i <= 6*n; i ++){
            double p = arr[flag][i] / count;
            System.out.println(i + "\t" + p);
        }
    }
}
