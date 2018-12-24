package basic.Array;
//计算二维数组和
public class Array_Eg3 {
    public static void main(String[] args){
        int[][] arr = new int[][]{{3,8,2},{2,7},{9,0,1,6}};
        int sum = 0;
        for (int i = 0;i < arr.length; i++){
            for(int j = 0;j < arr[i].length; j++){
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
