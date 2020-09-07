package examination.滴滴;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int N = sc.nextInt();
        process(N);
    }
    static class Num {
        int abc;
        int acc;
        Num(int abc, int acc){
            this.abc = abc;
            this.acc = acc;
        }
    }
    public static void process(int n){
        int gewei = n % 10;
        if (gewei % 2 == 1){
            System.out.println(0);
            return;
        }
        n /= 10;
        int shiwei = n % 10;
        int rest = n / 10;
        int a = rest / 2;
        if (a == 0){
            System.out.println(0);
            return;
        }
        int diff = rest - a * 2;
        ArrayList<Num> list = new ArrayList<>();
        if (diff == 0){
            int c = gewei / 2;
            if (shiwei - c >= 0 && valid(a,shiwei - c, c)){
                list.add(new Num(a * 100 + (shiwei - c) * 10 + c, a * 100 + c * 10 + c));
            }
            c = (10 + gewei) / 2;
            if (shiwei - c - 1 >= 0 && valid(a, shiwei - c - 1, c)){
                list.add(new Num(a * 100 + (shiwei - c - 1) * 10 + c, a * 100 + c * 10 + c));
            }
        }else{
            int c = gewei / 2;
            if (10 + shiwei - c >= 0 && 10 + shiwei - c < 10 && valid(a, 10 + shiwei - c, c)){
                list.add(new Num(a * 100 + (10 + shiwei - c) * 10 + c, a * 100 + c * 10 + c));
            }
            c = (10 + gewei) / 2;
            if (10 + shiwei - c - 1 >= 0 && 10 + shiwei - c - 1 < 10 && valid(a, 10 + shiwei - c - 1,c)){
                list.add(new Num(a * 100 + (10 + shiwei - c - 1) * 10 + c, a * 100 + c * 10 + c));
            }
        }
        System.out.println(list.size());
        Collections.sort(list,(o1, o2) -> o1.abc - o2.abc);
        for (Num num : list){
            System.out.printf("%d %d\n", num.abc, num.acc);
        }
    }
    public static boolean valid(int a, int b, int c){
        if (a == b || a == c || b == c){
            return false;
        }
        return true;
    }
}