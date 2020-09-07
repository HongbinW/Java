package nowcode.byteDance.春招2019;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/29
 */

// "1" 2 3 5 没做出来
public class Main1_编辑去除重复字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] strs = new String[N];
        for (int i = 0; i < N; i ++){
            strs[i] = sc.nextLine();
        }
        String[] res = fix(strs);
        for (int i = 0; i < res.length; i ++){
            System.out.println(res[i]);
        }
    }
    public static String[] fix(String[] strs){
        String[] res = new String[strs.length];
        for (int i = 0; i < strs.length; i ++){
            res[i] = process(strs[i].toCharArray());
        }
        return res;
    }
    public static String process(char[] chs){
        if (chs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(chs[0]);
        int index = 1;
        int count = 1;
        int pre = 0;
        while (index < chs.length){
            if (chs[index] == chs[index-1]){
                count ++;
            }else{
                pre = count;
                count = 1;
            }
            if (count > 2) {        // 如果超过两个，那就保持两个好了
                count = 2;
            }else if (pre >= 2 && count >= 2){
                // 如果前一个是2个，那么现在肯定不会超过2个，前面加了此处再减掉。
                // 这样可以有效防止AABBCC的情况，因为对于B已经减到1了，所以C可以保持2个
                count --;
            }else {
                sb.append(chs[index]);
            }
            index ++;
        }
        return sb.toString();
    }

    // 神仙做法 正则表达式
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {
            System.out.println(scanner.nextLine().replaceAll("(.)\\1+","$1$1").replaceAll("(.)\\1(.)\\2","$1$1$2"));
        }
    }
}
