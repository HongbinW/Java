package LeetCode.tencent_50Questions;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89_grayCode {
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1 << n; i++){
            list.add(i ^ i >> 1);
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
