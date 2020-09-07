package LeetCode.会员.大疆;

import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/16
 */
public class LeetCode469_isConvex_凸多边形 {
    // p1p2  叉乘 p2p3， 要求结果一直为正或一直为负， 叉乘是sin
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long cur, pre = 0;
        for (int i = 0; i < n; i++) {
            cur = crossProduct(points.get((i + 1) % n).get(0) - points.get(i).get(0),
                    points.get((i + 1) % n).get(1) - points.get(i).get(1),
                    points.get((i + 2) % n).get(0) - points.get(i).get(0),
                    points.get((i + 2) % n).get(1) - points.get(i).get(1));
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;
    }

    private long crossProduct(long x1, long y1, long x2, long y2) {
        return x1 * y2 - x2 * y1;
    }
}
