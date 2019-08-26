import java.util.*;

/**
 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
class Test {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        char[] c = new char[s.length()];
        int p1 = 0;
        int p2 = s.length()-1;
        while(p1 <= p2){
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);
            if(!vowels.contains(c1))
                c[p1++] = c1;
            else if(!vowels.contains(c2))
                c[p2--] = c2;
            else{
                c[p1++] = c1;
                c[p2++] = c2;
            }
        }

        return new String(c);
    }
}