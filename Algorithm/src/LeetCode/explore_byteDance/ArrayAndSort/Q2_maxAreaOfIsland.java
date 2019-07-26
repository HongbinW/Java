package LeetCode.explore_byteDance.ArrayAndSort;

public class Q2_maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        for(int i = 0 ; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    count = Math.max(process(grid,i,j),count);
                }
            }
        }
        return count;
    }
    private int process(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1){
            return 0;
        }else{
            grid[row][col] = 2;
            return 1 + process(grid,row+1,col) + process(grid,row-1,col) + process(grid,row,col+1) + process(grid,row,col-1);
        }

    }

    public static void main(String[] args) {

    }
}
