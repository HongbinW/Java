package examination.ByteDance.SummerCamp2;

import java.util.*;

/*
    要匹配的字符串Thisisadog
    匹配数组：This Thisis a dog
    返回TRUE
    问题在于：比如有这样一个匹配数组:Thisisad og This is a ，其实应该输出TRUE的，但是，如果先匹配This，则为FALSE
    通过率50%.
    要解决当字符串相同或包含时，应用哪个字符串去匹配的问题。
 */
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


//正解:动态规划
class Solution {
    public static boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return false;
        }
        boolean[] flag = new boolean[s.length() + 1];   //flag[i]表示到第i个位置，是否能匹配上
        flag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (flag[j] && dict.contains(s.substring(j, i))) {  //如果j之前的位置匹配上了，如果s.substring(j, i)子串也能匹配上，则位置i也为true
                    flag[i] = true;
                    break;
                } else {
                    flag[i] = false;
                }

            }
        }
        return flag[s.length()];
    }
    public static void main(String[] args) {
        String str = "Thisisadog";
        HashSet<String> set = new HashSet<>();
        set.add("This");
        set.add("is");
        set.add("a");
        set.add("og");
        set.add("Thisisad");
        System.out.println(wordBreak(str,set));
    }
}
