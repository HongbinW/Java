package LeetCode.会员.华为;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/28
 */
public class LeetCode554_leastBricks_砖墙 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(1,1));
        System.out.println(leastBricks2(list));
    }
    public static int leastBricks(List<List<Integer>> wall) {
        HashMap < Integer, Integer > map = new HashMap< >();
        for (List < Integer > row: wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }
        int res = wall.size();
        for (int key: map.keySet())
            res = Math.min(res, wall.size() - map.get(key));
        return res;
    }

    public static int leastBricks2(List < List < Integer >> wall) {
        int[] pos = new int[wall.size()];
        int c = 0, sum = 0, res = Integer.MAX_VALUE;
        for (int el: wall.get(0))
            sum += el;
        while (sum != 0) {
            int count = 0;
            for (int i = 0; i < wall.size(); i++) {
                List < Integer > row = wall.get(i);
                if (row.get(pos[i]) != 0)
                    count++;
                else
                    pos[i]++;
                row.set(pos[i], row.get(pos[i]) - 1);
            }
            sum--;
            res = Math.min(res, count);
        }
        return res;
    }
}
