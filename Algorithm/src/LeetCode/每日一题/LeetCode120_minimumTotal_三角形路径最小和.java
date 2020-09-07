package LeetCode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/14
 */
public class LeetCode120_minimumTotal_三角形路径最小和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()){
            return 0;
        }
        List<Integer> list = new ArrayList<>(triangle.get(triangle.size()-1));
        for (int i = triangle.size() - 2; i >= 0; i --){
            for (int j = 0; j < triangle.get(i).size(); j ++){
                list.set(j,Math.min(list.get(j),list.get(j+1)) + triangle.get(i).get(j));
            }
        }
        return list.get(0);
    }
}
