package examination.ByteDance.SummerCamp2;
/*
    两种颜色方块，黑色B块，白色W块
    将这些方块堆成塔，塔最顶上放一块，往下依次加一块，每一层只能放一种颜色，最后一层放h块。
    求这些方块所能堆出来的塔的最大高度。并求堆成该高度有几种方法

    测试用例 4 6
    输出结果 4 2
    即，白色4块，黑色6块，最大高度4，一共有两种。
    算法复杂度高，40%通过
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int w = sc.nextInt();
            int b = sc.nextInt();
            int h = 0;
            while(h*(h+1) <= 2*(w+b)){
                h++;
            }
            h--;
            int temp = 2*(w+b)-h*(h+1);
            process(w,b,1,h,temp);
            System.out.print(h + " " + res % 1000000007);
        }
    }
    static int res = 0;
    public static void process(int curW, int curB, int curH, int h, int temp){ //当前剩余w和b的块数,当前的高度
        if(curB < 0 || curW < 0 || curB > temp && curB < curH || curW > temp && curW < curH){
            return;
        }
        if(curH == h + 1){
            res ++;
            return;
        }
        process(curW-curH,curB,curH+1,h,temp);
        process(curW,curB-curH,curH+1,h,temp);
    }
}