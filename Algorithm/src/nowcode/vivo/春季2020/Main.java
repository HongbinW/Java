package nowcode.vivo.春季2020;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/31
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().solution(1,2));
    }
    public int solution (int m, int n) {
        int res = 0;
        for (int i = m; i <= n; i ++){
            boolean[][] visited = new boolean[3][3];
            int bb = process(visited,0,0,i,1);
            visited = new boolean[3][3];
            int bm = process(visited,0,1,i,1);
            visited = new boolean[3][3];
            int mm = process(visited,1,1,i,1);
            res += 4 * bb + 4 * bm + mm;
        }
        return res;
    }
    public int process(boolean[][] visited, int row, int col, int total, int count){
        if (row < 0 || row >= 3 || col < 0 || col >= 3){
            return 0;
        }else if (total == count){
            return 1;
        }
        visited[row][col] = true;
        int cur = process(visited,row+1,col,total,count+1)
                + process(visited,row-1,col,total,count+1)
                + process(visited,row,col+1, total,count+1)
                + process(visited,row,col-1, total,count+1)
                + process(visited,row-1,col-1,total,count+1)
                + process(visited,row-1,col+1,total,count+1)
                + process(visited,row+1,col-1,total,count+1)
                + process(visited,row+1,col+1,total,count+1);

        visited[row][col] = false;
        return cur;
    }
}
