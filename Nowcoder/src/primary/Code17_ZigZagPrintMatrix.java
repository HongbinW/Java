package primary;

/**
 * @Author: HongbinW
 * @Date: 2019/3/16 16:08
 * @Version 1.0
 */
//“之”字型打印矩阵
public class Code17_ZigZagPrintMatrix {
    public static void ZigZagPrintMatrix(int[][] matrix){       //A走到最后一行或者B走到最后一列即停止
        int Ar = 0, Ac = 0, Br = 0, Bc = 0;             //A,B坐标
        boolean Uptodown = false;
        while(Ar <= matrix.length-1 && Ac <= matrix[0].length-1){
            if(Uptodown){
                for(int i = 0; i <= Br-Ar; i++) {
                    System.out.println(matrix[Ar+i][Ac-i]);
                }
                Uptodown = !Uptodown;
            }else{
                for(int i = 0; i <= Br-Ar; i++) {
                    System.out.println(matrix[Br-i][Bc+i]);
                }
                Uptodown = !Uptodown;
            }

            if(Ac < matrix[0].length-1){
                Ac++;
            }else{
                Ar++;
            }
            if(Br < matrix.length-1){
                Br++;
            }else{
                Bc++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        ZigZagPrintMatrix(matrix);
    }
}
