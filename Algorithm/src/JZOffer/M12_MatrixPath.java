package JZOffer;

/**
 * @Author: HongbinW
 * @Date: 2019/3/17 9:55
 * @Version 1.0
 */
public class M12_MatrixPath {
    public static boolean matrixPath(char[][] matrix, String target){
        int startrow = 0;
        int startcol = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == target.charAt(0)){
                    boolean[][] mark = new boolean[matrix.length][matrix[0].length];
                    startrow = i;
                    startcol = j;
                    if(matrixPath(matrix,mark,target,startrow,startcol,0))
                        return true;
                }
            }
        }
        return false;
    }
    private static boolean matrixPath(char[][] matrix, boolean[][] mark,String target, int cr, int cl, int i){
        //cr为当前的行，cl为当前的列，i为目前是在找第几个元素
        if(i == target.length()){       //
            return true;
        }
        if(cr < 0 || cr >=matrix.length || cl < 0 || cl >= matrix[0].length){
            return false;
        }
        //递归
        if(!mark[cr][cl] && matrix[cr][cl] == target.charAt(i)){
            mark[cr][cl] = true;
            return matrixPath(matrix,mark,target,cr-1,cl,i+1) ||
            matrixPath(matrix,mark,target,cr+1,cl,i+1) ||
            matrixPath(matrix,mark,target,cr,cl-1,i+1) ||
            matrixPath(matrix,mark,target,cr,cl+1,i+1);
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        System.out.println(matrixPath(matrix,"cabfj"));
    }
}
