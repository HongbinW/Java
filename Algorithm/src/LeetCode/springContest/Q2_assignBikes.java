package LeetCode.springContest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @Author: HongbinW
 * @Date: 2019/4/14 16:55
 * @Version 1.0
 * @Description:
 * 在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。
 *
 * 我们需要为每位工人分配一辆自行车。在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对  (worker, bike) ，
 * 并将其中的自行车分配給工人。如果有多个 (worker, bike) 对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。
 * 类似地，如果有多种不同的分配方法，则选择自行车索引最小的一对。不断重复这一过程，直到所有工人都分配到自行车为止。
 * （如果距一员工距离相同，则选自行车索引最小的）
 *
 * 给定两点 p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。
 *
 * 返回长度为 n 的向量 ans，其中 a[i] 是第 i 位工人分配到的自行车的索引（从 0 开始）。
 *
 * 输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * 输出：[0,2,1]
 * 解释：
 * 工人 0 首先分配到自行车 0 。工人 1 和工人 2 与自行车 2 距离相同，因此工人 1 分配到自行车 2，
 * 工人 2 将分配到自行车 1 。因此输出为 [0,2,1]。（因为车辆2离的更近）
 */
public class Q2_assignBikes {
    public static int[] assignBikes(int[][] workers, int[][] bikes) {
        int[][] value = new int[workers.length][bikes.length];
        for(int i = 0; i < workers.length;i++){
            for(int j = 0; j < bikes.length; j++){
                value[i][j] = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
            }
        }
        HashSet<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < workers.length; i++){
            int j = 0;
            while(set.contains(j)){
                j++;
            }
            int minIndex = j;
            while(j < bikes.length){
                while(set.contains(j) && j < bikes.length){
                    j++;
                }
                if(j < bikes.length && value[i][j] < value[i][minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            set.add(minIndex);
        }
        int[] res = new int[workers.length];
        int n = 0;
        for(int item : set){
            res[n++] = item;
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
        int[][] workers = new int[][]{{0,0},{1,1},{2,0}};
        int[][] bikes = new int[][]{{1,0},{2,2},{2,1}};
        printArray(assignBikes(workers,bikes));
    }

}
