package LeetCode.每日一题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/8
 */
public class M16_11_divingBoard_跳水板可能的长度 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[0];
        }
        if(shorter==longer){
            return new int[]{k*shorter};

        }
        int[] res = new int[k+1];
        for(int i=0;i<k+1;i++){
            res[i] = (k-i)*shorter+i*longer;
        }
        return res;
    }
}
