package examination.tencent.nowcoder2017_summer;

import java.util.Scanner;

/**
 * @Author: HongbinW
 * @Date: 2019/9/4 20:22
 * @Version 1.0
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(process(str));
        }
    }
    private static int process(String str){
        char[] chs = new char[str.length() * 2 - 1];
        int index = 0;
        for (int i = 0; i < str.length(); i ++){
            chs[index++] = str.charAt(i);
            if (index < str.length())
                chs[index++] = '#';
        }
        int count = 0;
        for (int i = 2; i < chs.length; i ++){
            int left = i - 1;
            int right = i + 1;
            int temp = 0;
            while (left >= 0 && right < chs.length){
                if (chs[left] != chs[right]){

                }
            }
        }
        return count;
    }
}
