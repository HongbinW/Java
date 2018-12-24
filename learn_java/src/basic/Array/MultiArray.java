package basic.Array;

public class MultiArray {
    public static void main(String[] args){
        int[] scores = new int[10];
        String[][] names;
        //1.二维数组的初始化
        int[][] scores2 = new int[][]{{1,2,3},{3,4,5},{6}}; //静态初始化

        //names = new String[3][2];   //动态初始化方式一
        names = new String[3][];    //动态初始化方式二
        names[0] = new String[2];   //有点降维的意思
        names[1] = new String[]{"WHB","Frank"};
        names[2] = new String[2];

        /*for(int i = 0;i < names.length;i++){
            for(int j = 0;j < names[i].length;j++)
            System.out.println(names[i][j]);
        }*/

        //错误的初始化方式
        /*names = new String[][];
        names = new String[][2];*/

        //2.数组长度
        System.out.println(scores2.length); //3
        //二维数组中某一元素的个数
        System.out.println(scores2[2].length); //1

        //3.内存结构
        int[] x,y[];    //x是一维的，y是二维的
        y = new int [3][2];
        x = y[0];
        x[0] = y[1][1];



    }
}
