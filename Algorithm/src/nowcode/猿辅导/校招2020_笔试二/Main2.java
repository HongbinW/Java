package nowcode.猿辅导.校招2020_笔试二;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/19
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        String source = sc.next();
        String target = sc.next();
        process(N,M,K,source.toCharArray(),target.toCharArray());
    }
    public static void process(int n, int m, int k, char[] source, char[] target){
        int diff = 0;
        for (int i = 0; i < source.length; i ++){
            if (source[i] != target[i]){
                diff ++;
            }
        }

    }
}
