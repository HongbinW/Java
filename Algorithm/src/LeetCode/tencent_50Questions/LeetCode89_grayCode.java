package LeetCode.tencent_50Questions;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89_grayCode {
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1 << n; i++){
            list.add(i ^ i >> 1);   //右移一位，这样最左边补上0，与0异或就是其本身。此外打印数量就是1 <<n，这样就可以打印从1到 1<<n个格雷码了
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = grayCode(4);
        for(int ele : list){
            System.out.println(ele);
        }
    }
}
