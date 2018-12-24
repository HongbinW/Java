package basic.Array;
//数组常见异常
public class ArrayException {
    public static void main(String[] args){
        //1.数组下表越界
        int[] i = new int[10];
        i[0] = 90;
    //    i[10] = 99;

        //2.空指针的异常
        //第一种
//        boolean[] b = new boolean[3];
//        b = null;   //不再指向原来数组,空指针
//        System.out.println(b[0]);

        //第二种
//        String[] str = new String[4];
//        //str[3] = new String("AA");
//        System.out.println(str[3].toString());//因为str[3]是空，toString指向另外的地方，所以不行

        //第三种
        //int[][] j = new int[3][];   //如下例，对于二维数组先生成一个三个元素的数组，
                                     // 第二维的时候，相当于第一维中每个元素又重新指向一个数组


        //j[2][0] = 12;       //同理，数组为引用类型，因为未初始化，所以j[2][0] = null，所以相当于一个空指针
        int[][] k = new int[3][];
        k[0] = new int[2];
        k[1] = new int[3];
        k[2] = new int[]{1,2,3};
        for(int m = 0; m < k.length ; m++){
            System.out.println(k[m]);}
            System.out.println();
        for(int m = 0; m < k.length ; m++){
            for(int n = 0; n < k[m].length ; n++)
                System.out.println(k[m][n]);
        }
        System.out.println(k[2][0]);

    }
}
