package examination.HuaWei.huawei_test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: HongbinW
 * @Date: 2019/4/27 10:51
 * @Version 1.0
 * @Description: https://www.nowcoder.com/discuss/173040
 * 现有多维数组，需要将它们合并成一个新的数组，合并规则：从每个数组中按顺序取出
 * 固定长度的内容，合并到新的数组中，取完内容会删掉，如果该行不足固定长度或已经
 * 为空，则直接取出剩余部分，继续下一行。
 * EG：
 * 输入：
 * 3
 * 2,5,6,7,9,5,7
 * 1,7,4,3,4
 * 输出
 * 2,5,6,1,7,4,7,9,5,3,4,7
 * 即，每次取三个，先在第一个数组去2,5,6，再去第二个取1,7,4，再回第一个取7,9,5
 * 再去第二个取3,4，再去第一个取7
 */
public class E2 {
    public static int[] merge(int num, int[][] arr){
        int len = 0;
        for(int m = 0; m < arr.length; m++){
            for(int n = 0; n < arr[m].length;n++){
                len++;
            }
        }
        int[] res = new int[len];
        int index = 0;
        int[] curIndex = new int[arr.length];
        int i = 0;
        while(index < len){
            //当前要操作的数组
            int cur = i % arr.length;
            //每个数组的当前位置，至当前位置+3，且不超出其长度
            for(int k = curIndex[cur]; k < arr[cur].length && k < curIndex[cur] + 3; k++) {
                res[index++] = arr[cur][k];
            }
            curIndex[cur] = curIndex[cur] + num < arr[cur].length ? curIndex[cur] + num : arr[cur].length-1;
            i++;
        }
        return res;
    }

    public static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,5,6,7,9,5,7},{1,7,4,3,4}};
        printArray(merge(3,matrix));
    }

}
