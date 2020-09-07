package LeetCode.casuallly;

import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/3/29
 */
//1找最远的0
public class LeetCode1162_maxDistance_地图分析 {
    class Node{
        int row;
        int col;
        int value;
        public Node(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    public int maxDistance(int[][] grid) {
        LinkedList<Node> list = new LinkedList<>();
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if (grid[i][j] == 1){
                    list.add(new Node(i,j,0));
                }
            }
        }
        if (list.size() == grid.length * grid[0].length || list.size() == 0){
            return -1;
        }
        int res = -1;
        while (!list.isEmpty()){
            Node node = list.pop();
            res = node.value;
            processNode(grid,list,node);
        }
        return res;
    }
    public void processNode(int[][] grid, LinkedList<Node> list, Node node){
        int row = node.row;
        int col = node.col;
        if (row - 1 >= 0 && grid[row-1][col] == 0){     //可以理解为这个地方已经来过，可算做陆地了
            list.add(new Node(row-1,col,node.value+1));     //可那个这个地方继续去找更远的海洋
            grid[row-1][col] = 1;
        }
        if (row + 1 < grid.length && grid[row+1][col] == 0){
            list.add(new Node(row+1,col,node.value+1));
            grid[row+1][col] = 1;
        }
        if (col - 1 >= 0 && grid[row][col-1] == 0){
            list.add(new Node(row,col-1,node.value+1));
            grid[row][col-1] = 1;
        }
        if (col + 1 < grid[0].length && grid[row][col+1] == 0){
            list.add(new Node(row,col+1,node.value+1));
            grid[row][col+1] = 1;
        }
    }
}
