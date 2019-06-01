package examination.ByteDance.SummerCamp2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String target = sc.nextLine();
            if(target.equals(""))
                break;
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            Arrays.sort(strs,new MyComparator());   //将字符串从长到短排序
            for (int i = 0; i < strs.length; i ++){
                if (target.contains(strs[i])) {
                    String target1 = target;
                    int start = target1.indexOf(strs[i]);
                    String pre = target1.substring(0, start);
                    String post = target1.substring(start + strs[i].length());
                    target1 = pre + post;
                    for (int j = 0; j < strs.length; j++) {
                        if(j == i)
                            continue;
                        if (target1.contains(strs[i])) {
                            start = target1.indexOf(strs[i]);
                            pre = target1.substring(0, start);
                            post = target1.substring(start + strs[i].length());
                            target1 = pre + post;
                            if (target1.length() == 0) {
                                System.out.println("True");
                            }
                        }
                    }
                }
            }
            System.out.println("False");
        }
    }
}
class MyComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String str1 = (String)o1;
        String str2 = (String)o2;
        return str2.length()-str1.length();
    }
}
