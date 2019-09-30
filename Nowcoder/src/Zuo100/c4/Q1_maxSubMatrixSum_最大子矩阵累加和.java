package Zuo100.c4;

/**
 * 思路：按层累加，每层进行最大子数组累加和
 */
//未OJ
public class Q1_maxSubMatrixSum_最大子矩阵累加和 {
    public static int maxSubMatrixSum(int[][] matrix){
        int[] help = null;
        int res = matrix[0][0];
        int cur = 0;
        for (int i = 0; i < matrix.length; i ++){
            help = new int[matrix[0].length];   //每次开始的时候初始化数组
            for (int j = i; j < matrix.length; j ++){   //从第i行开始累加
                cur = 0;
                for (int k = 0; k < matrix[0].length; k ++){    //边累加，边求值
                    help[k] += matrix[j][k];
                    cur = cur + help[k] > help[k] ? cur + help[k] : help[k];
                    res = Math.max(cur,res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(maxSubMatrixSum(new int[][]{
//                {-90,48,78},
//                {64,-40,64},
//                {-81,-7,66}
//        }));    //209
        System.out.println(maxSubMatrixSum(new int[][]{
                {-1,-1,-1},
                {-1,2,2},
                {-1,-1,-1}
        }));
    }
}

