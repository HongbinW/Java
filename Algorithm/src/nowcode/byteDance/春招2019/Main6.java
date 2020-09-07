package nowcode.byteDance.春招2019;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/29
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int diff = 1024 - N;
        int count = 0;
        if (diff > 0){
            count += diff / 64;
            diff -= diff / 64 * 64;
        }
        if (diff > 0){
            count += diff / 16;
            diff -= diff / 16 * 16;
        }
        if (diff > 0){
            count += diff / 4;
            diff -= diff / 4 * 4;
        }
        count += diff;
        System.out.println(count);
    }
}
