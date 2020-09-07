package LeetCode.会员.拼多多;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/2
 */
public class LeetCode1020_numEnclaves_不能走出矩阵的单元数量 {
    public static void main(String[] args) {
        System.out.println(new LeetCode1020_numEnclaves_不能走出矩阵的单元数量().numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
    }
    public int numEnclaves(int[][] A) {
        for(int i = 0; i < A[0].length; i ++){
            if (A[0][i] == 1){
                process(A,0,i);
            }
            if (A[A.length-1][i] == 1){
                process(A,A.length-1,i);
            }
        }
        for (int i = 0; i < A.length; i ++){
            if (A[i][0] == 1){
                process(A,i,0);
            }
            if (A[i][A[0].length-1] == 1){
                process(A,i,A[0].length-1);
            }
        }
        int res = 0;
        for (int i = 1; i < A.length - 1; i ++){
            for (int j = 1; j < A[0].length - 1; j ++){
                if (A[i][j] == 1){
                    res ++;
                }
            }
        }
        return  res;
    }
    public void process(int[][] A, int row, int col){
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || A[row][col] != 1){
            return;
        }
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        A[row][col] = 2;
        for (int i = 0; i < 4; i ++){
            int x = row + dx[i];
            int y = col + dy[i];
            process(A,x,y);
        }
    }
}
