package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/11
 */
public class LeetCode130_solve_被围绕的区域 {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i ++){
            if (board[i][0] == 'O' && !visited[i][0]){
                process(board,visited,row,col,i,0);
            }
            if (board[i][col-1] == 'O' && !visited[i][col-1]){
                process(board,visited,row,col,i,col-1);
            }
        }
        for (int i = 0; i < col; i ++){
            if (board[0][i] == 'O' && !visited[0][i]){
                process(board,visited,row,col,0,i);
            }
            if (board[row-1][i] == 'O' && !visited[row-1][i]){
                process(board,visited,row,col,row-1,i);
            }
        }
        for (int i = 1; i < row - 1; i ++){
            for (int j = 1; j < col - 1; j ++){
                if (!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void process(char[][] board, boolean[][] visited, int row, int col, int i, int j){
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == 'X' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        for (int m = 0; m < 4; m ++){
            int x = i + dx[m];
            int y = j + dy[m];
            process(board,visited,row,col,x,y);
        }
    }
}
