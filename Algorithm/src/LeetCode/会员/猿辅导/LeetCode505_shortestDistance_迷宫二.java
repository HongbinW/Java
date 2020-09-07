package LeetCode.会员.猿辅导;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */
public class LeetCode505_shortestDistance_迷宫二 {
    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{2,4};
        int[] destination = new int[]{4,4};
        System.out.println(new LeetCode505_shortestDistance_迷宫二().shortestDistance3(maze,start,destination));
    }
    // 超时 暴力
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int res = process(maze,start,destination,maze.length,maze[0].length,visited);
        return res >= maze.length * maze[0].length ? -1 : res;
    }
    public int process(int[][] maze, int[] start, int[] destination, int rows, int cols, boolean[][] visited){
        if (start[0] == destination[0] && start[1] == destination[1]){
            return 0;
        }
        if (visited[start[0]][start[1]] || maze[start[0]][start[1]] == 1){
            return rows * cols;
        }
        visited[start[0]][start[1]] = true;
        int up = start[0];
        int down = start[0];
        int left = start[1];
        int right = start[1];
        while (up >= 0 && maze[up][start[1]] == 0){
            up --;
        }
        if (up == -1 || maze[up][start[1]] == 1){
            up ++;
        }
        while (down < rows && maze[down][start[1]] == 0){
            down ++;
        }
        if (down == rows || maze[down][start[1]] == 1){
            down --;
        }
        while (left >= 0 && maze[start[0]][left] == 0){
            left --;
        }
        if (left == -1 || maze[start[0]][left] == 1){
            left ++;
        }
        while (right < cols && maze[start[0]][right] == 0){
            right ++;
        }
        if (right == cols || maze[start[0]][right] == 1){
            right --;
        }
        int res = start[0] - up + process(maze,new int[]{up,start[1]},destination,rows,cols,visited);
        res = Math.min(down - start[0] + process(maze,new int[]{down,start[1]},destination,rows,cols,visited), res);
        res = Math.min(start[1] - left + process(maze,new int[]{start[0],left},destination,rows,cols,visited), res);
        res = Math.min(right - start[1] + process(maze,new int[]{start[0],right},destination,rows,cols,visited), res);
        visited[start[0]][start[1]] = false;
        return res;
    }

    // ac
    public int shortestDistance3(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] dir: dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {  //多+了，减回来
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
            }
        }
    }

}
