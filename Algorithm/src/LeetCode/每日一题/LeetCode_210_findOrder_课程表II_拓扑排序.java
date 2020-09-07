package LeetCode.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/17
 */
public class LeetCode_210_findOrder_课程表II_拓扑排序 {
    public static void main(String[] args) {
//        int[] res = new Solution().findOrderBFS(2,new int[][]{{1,0},{0,1}});
        int[] res = new LeetCode_210_findOrder_课程表II_拓扑排序().findOrderBFS(4 ,new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for (int i = 0; i < res.length; i ++){
            System.out.println(i);
        }
    }
    // DFS
    // 思路：深度优先遍历，逆向思维
    // 每个节点有三个状态，0 : 未检索、 1：检索中、2：检索完成
    // 如果搜到某个节点时，该节点状态是1，则说明成环了。每次搜索完他的子节点后，把该节点放入栈中，并将状态置为2
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int[] flag = new int[numCourses]; // 0 : 未检索、 1：检索中、2：检索完成
        for (int i = 0; i < prerequisites.length; i ++){
            if (!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < flag.length; i ++){
            if (flag[i] == 1){
                return new int[0];
            }else if (flag[i] == 2){
                continue;
            }
            int[] arr = process(stack,map,i,flag);
            if (arr != null){
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()){
            res[index++] = stack.pop();
        }
        return res;
    }
    public int[] process(Stack<Integer> stack,  HashMap<Integer,ArrayList<Integer>> map, int i, int[] flag){
        if (flag[i] == 1){
            return new int[0];
        }
        if (flag[i] == 2){
            return null;
        }
        if (!map.containsKey(i)){
            flag[i] = 2;
            stack.push(i);
            return null;
        }
        flag[i] = 1;
        for (int j = 0; j < map.get(i).size(); j ++){
            int[] arr = process(stack,map,map.get(i).get(j),flag);
            if (arr != null){
                return new int[0];
            }
        }
        flag[i] = 2;
        stack.push(i);
        return null;
    }

    // BFS
    // 思路： 宽度优先，正向思维
    // 如果一个节点的入度（指向该节点的个数）为0，说明该节点所有预先要学的课程都结束了，所以可以放入res中。
    // 因此需要维护每个节点的入度和当前入度为0的队列.

    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int[] enterCount = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i ++){
            if (!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            enterCount[prerequisites[i][0]] ++;
        }
        for (int i = 0; i < numCourses; i ++){
            if (enterCount[i] == 0){
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int size = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            res[size++] = cur;
            for (int i = 0; map.containsKey(cur) && i < map.get(cur).size(); i ++){
                enterCount[map.get(cur).get(i)] --;
                int tmp = enterCount[map.get(cur).get(i)];
                if (tmp <= 0){
                    queue.add(map.get(cur).get(i));
                }
            }
        }
        return size == numCourses ? res : new int[0];
    }
}
