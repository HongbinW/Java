package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/4/2
 */

//思路，因为要同时更换，所以可以增加状态量，比如可以用2表示原来是0现在是1
public class LeetCode289_gameOfLife_生命游戏 {
    public static void main(String[] args) {
        new LeetCode289_gameOfLife_生命游戏().new Solution().gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
    class Solution {
        public void gameOfLife(int[][] board) {
            int[] neighbor = new int[]{0,1,-1};
            for(int i = 0; i < board.length; i ++){
                for(int j = 0; j < board[0].length; j ++){
                    int count = 0;
                    for(int m = 0; m < neighbor.length; m ++){
                        int row = i + neighbor[m];
                        if(row < 0 || row >= board.length){
                            continue;
                        }
                        for(int n = 0; n < neighbor.length; n ++){
                            if(neighbor[m] == 0 && neighbor[n] == 0){
                                continue;
                            }
                            int col = j + neighbor[n];
                            if(col < 0 || col >= board[0].length){
                                continue;
                            }
                            if(board[row][col] == 1 || board[row][col] == 3){
                                count ++;
                            }
                        }
                    }
                    if(board[i][j] == 0 ){
                        if (count == 3) {
                            board[i][j] = 2;
                        }
                    }else {
                        if(board[i][j] == 1 && (count == 2 || count == 3)){
                            board[i][j] = 1;
                        }else{
                            board[i][j] = 3;

                        }
                    }
                }
            }
            for(int i = 0; i < board.length; i ++){
                for(int j = 0; j < board[0].length; j ++){
                    if(board[i][j] == 2){
                        board[i][j] = 1;
                    }else if(board[i][j] == 3){
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
}
