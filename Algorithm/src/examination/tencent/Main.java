package examination.tencent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()){
//            int n = sc.nextInt();
            int count = 0;
        int n = 100;
            for (int i = 2; i <= n / 2; i ++) {
                if (i == 2 || i == 3 || i == 5){

                }
                else if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                    continue;
                }
                    int temp = n - i;
                    if (temp == 2 || temp == 3 || temp == 5){
                        count ++;
                    }
                    else if (temp % 2 == 0 || temp % 3 == 0 || temp % 5 == 0 || temp % 11 == 0) {
                        continue;
                    }else{
                        count ++;
                    }

            }
            System.out.println(count);
        }
//    }
}
