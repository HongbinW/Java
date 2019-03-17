package JZOffer;

/**
 * @Author: HongbinW
 * @Date: 2019/3/17 10:53
 * @Version 1.0
 */
public class M13_RobotMovingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visit = new boolean[rows][cols];
        int count = movingCount(threshold,rows,cols,0,0,visit);
        return count;
    }
    private int movingCount(int threshold, int rows, int cols, int row, int col,boolean[][] visit){
        int count = 0;
        if(row >=0 && row < rows && col >= 0 && col < cols && !visit[row][col]
                && getDigitSum(row) + getDigitSum(col) <= threshold){
            visit[row][col] = true;
            count = 1 + movingCount(threshold,rows,cols,row-1,col,visit)+
                    movingCount(threshold,rows,cols,row+1,col,visit)+
                    movingCount(threshold,rows,cols,row,col-1,visit)+
                    movingCount(threshold,rows,cols,row,col+1,visit);
        }
        return count;
    }

    private int getDigitSum(int number){
        int sum = 0;
        while(number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
