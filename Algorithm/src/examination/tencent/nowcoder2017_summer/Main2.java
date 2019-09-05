package examination.tencent.nowcoder2017_summer;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(process(str.toCharArray()));
        }
    }
    private static String process(char[] chs){
        for (int i = 1; i < chs.length; i ++){
            for (int j = i; j > 0; j --) {
                if (chs[j - 1] < 'a' && chs[j] >= 'a') {
                    swap(chs, j, j - 1);
                }
            }
        }
        return new String(chs);
    }
    private static void swap(char[] chs, int i, int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}

