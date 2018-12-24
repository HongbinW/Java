package basic.Array;
//杨辉三角
//1
//1 1
//1 2 1
//1 3 3 1
//1 4 6 4 1
//1 5 10 10 5 1
//…………
//打印10行
public class Array_Eg4 {
    public static void main(String[] args){
        int[][] yanghui = new int[10][];
        for (int i = 0; i < 10;i++){
            yanghui[i] = new int[i+1];
            yanghui[i][0] = 1;
            yanghui[i][i] = 1;
        }
        for (int i= 0;i < yanghui.length;i++){
            for (int j = 0;j < yanghui[i].length ;j++){
                if (yanghui[i][j] != 1){
                    yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
                }
            }
        }
        for (int i= 0;i < yanghui.length;i++) {
            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.print(yanghui[i][j] + " ");
            }
            System.out.println();
        }

    }
}
