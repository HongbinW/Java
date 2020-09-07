package examination.alibaba.yamei;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/3/30
 */
public class minMoves {
    public static void main(String[] args) {
        char[][] maps = new char[][]{};
    }

    static class Node{
        int row;
        int col;
        int times;
        public Node(int row, int col, int times){
            this.row = row;
            this.col = col;
            this.times = times;
        }
    }
    public static int minMoves(char[][] maps){
        ArrayList<Node> list = new ArrayList<>();
        int[][] dp = new int[maps.length][maps[0].length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int startRow = 0, startCol= 0;
        int endRow = 0, endCol = 0;
        int count = 0;
        for(int i = 0; i < maps.length; i ++){
            for (int j = 0; j < maps[0].length; j ++){
                if (maps[i][j] == 'S'){
                    startRow = i;
                    startCol = j;
                    count ++;
                }else if(maps[i][j] == 'E'){
                    endRow = i;
                    endCol = j;
                    count ++;
                }
            }
            if(count == 2){
                break;
            }
        }
        dp[endRow][endCol] = -1;

        initList(maps,endRow,endCol,dp,list,-1);
        while (!list.isEmpty()){
            Node node = list.get(0);
            list.remove(0);
            int reflectRow = maps.length - node.row;
            int reflectCol = maps.length - node.col;
            initList(maps,reflectRow, reflectCol, dp, list,node.times );
        }
        return dp[startRow][startCol];
    }

    public static void initList(char[][] maps, int row, int col, int[][] dp, ArrayList<Node> list, int times){
        if (row < 0 || row >= maps.length || col < 0 || col >= maps[0].length || maps[row][col] == '#'){
            return;
        }
        list.add(new Node(row,col,times+1));
        dp[row][col] = Math.min(dp[row+1][col],dp[row][col])+1;
        dp[row][col] = Math.min(dp[row-1][col],dp[row][col])+1;
        dp[row][col] = Math.min(dp[row][col+1],dp[row][col])+1;
        dp[row][col] = Math.min(dp[row][col-1],dp[row][col])+1;
        initList(maps,row+1,col,dp,list,times);
        initList(maps,row-1,col,dp,list,times);
        initList(maps,row,col+1,dp,list,times);
        initList(maps,row,col-1,dp,list,times);
    }

}
