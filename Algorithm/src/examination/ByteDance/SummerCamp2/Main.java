package examination.ByteDance.SummerCamp2;

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