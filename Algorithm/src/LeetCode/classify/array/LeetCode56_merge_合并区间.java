package LeetCode.classify.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: HongbinW
 * @Date: 2019/9/26 20:26
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/merge-intervals/
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */

/**
 * 思路：排序，有个count计数，将中间覆盖了的做个标记，之后就直接跳过
 */

public class LeetCode56_merge_合并区间 {
    //90% 81%
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals,new MyComparator());
        int standard = intervals[0][0] - 1;
        int count = 0;
        for (int i = 0; i < intervals.length; i ++){
            if (intervals[i][0] == standard){
                continue;
            }
            for (int j = i + 1; j < intervals.length; j ++){
                if (intervals[j][0] > intervals[i][1]) {
                    break;
                }else if (intervals[i][1] < intervals[j][1]){
                    intervals[i][1] = intervals[j][1];
                }
                intervals[j][0] = standard;
            }
            count ++;
        }
        int[][] res = new int[count][2];
        count = 0;
        for (int i = 0; i < intervals.length; i ++){
            if (intervals[i][0] == standard){
                continue;
            }else{
                res[count++] = intervals[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new LeetCode56_merge_合并区间().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}
class MyComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] > o2[0] ? 1 : o1[0] == o2[0] ? 0 :-1;      //表示出相等的情况很有必要，要不然会报错
    }
}
