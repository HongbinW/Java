package LeetCode.面试题系列;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/29
 */

// 抄的
public class M17_23_findSquare_最大黑矩形框 {
    int[][] matrix;
    int[] result=new int[]{0,0,0};
    public int[] findSquare2(int[][] matrix) {
        this.matrix=matrix;
        if(matrix.length==0){
            return new int[]{};
        }
        for(int i=0;i<matrix.length-result[2];i++){
            for(int j=0;j<matrix.length-result[2];j++){
                if(matrix[i][j]==0){
                    int count=1;
                    while(count+i<matrix.length&&count+j<matrix.length      //从一个点去看往下和往右能延伸的最大深度，再检查另两条边
                            &&matrix[count+i][j]==0&&matrix[i][count+j]==0
                            ){
                        count++;
                    }
                    int actualLen=isBlackMatrix(i,j,count);
                    if(actualLen>result[2]){
                        result[0]=i;
                        result[1]=j;
                        result[2]=actualLen;
                    }
                }
            }
        }
        if(result[2]==0){
            return new int[]{};
        }
        return result;
    }
    public int isBlackMatrix(int i,int j,int size){//recursive check
        if(size==1){
            return size;
        }
        else{
            for(int x=0;x<size;x++){
                if(matrix[i+size-1][j+x]==0&&matrix[i+x][j+size-1]==0){
                    continue;
                }
                else{
                    int miniLen=isBlackMatrix(i,j,size-1);
                    return miniLen;
                }
            }
            return size;
        }
    }
}
