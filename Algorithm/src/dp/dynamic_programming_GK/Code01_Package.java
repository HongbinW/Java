package dp.dynamic_programming_GK;

public class Code01_Package {
    public static int[][] condition = new int[5][9];
    static int[] w = new int[]{0,2,3,4,5};
    static int[] v = new int[]{0,3,4,5,6};
    static int[] item = new int[5];
    public static void FindMax(){
        int len = w.length;

        for(int i = 0; i < condition[0].length; i++) {
            condition[0][i] =0;
        }
        for(int i = 0; i < condition.length; i++) {
            condition[i][0] = 0;
        }
        for(int j = 1; j < condition[0].length; j++){       //列数，背包容量
            for(int i = 1; i < condition.length; i++){      //行数，物品i
                if(j < w[i]){
                    condition[i][j] = condition[i-1][j];
                }else{
                    condition[i][j] = Math.max(condition[i-1][j],condition[i-1][j-w[i]]+v[i]);
                }
            }
        }
        for(int i = 0; i < condition.length; i++){
            for(int j = 0; j < condition[0].length; j++){
                System.out.print(condition[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void FindWhat(int i,int j){
        if(i ==0 || j==0){
            return;
        }
        if(condition[i][j] == condition[i-1][j]){
            FindWhat(i-1,j);
        }else if( j-w[i]>=0 && condition[i][j]==condition[i-1][j-w[i]]+v[i] ){
            item[i]=1;//标记已被选中
            FindWhat(i-1,j-w[i]);//回到装包之前的位置
        }
    }

    public static void main(String[] args) {
        FindMax();
        FindWhat(4,8);
        for(int i = 0; i < item.length; i++){
            System.out.print(i + "\t");
            System.out.print(item[i] + "\t");
            System.out.println();
        }
    }
}
