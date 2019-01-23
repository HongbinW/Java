package easy;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/23
 */
/*
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
示例 :
输入: "IX"
输出: 9

示例 :
输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.

示例 :
输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInteger {
    public static void main(String[] args) {

    }
    public int MySolution(String s) {
        int countI = 0;
        int countV = 0;
        int countX = 0;
        int countL = 0;
        int countC = 0;
        int countD = 0;
        int countM = 0;
        byte[] b = s.getBytes();
        for(int i = 0; i < b.length; i ++){
            switch(b[i]){
                case 'I':
                    countI++;
                    break;
                case 'V':
                    countV++;
                    break;
                case 'X':
                    countX++;
                    break;
                case 'L':
                    countL++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                case 'M':
                    countM++;
                    break;
            }
        }
        if(s.contains("CD"))
            countC -=2;
        if(s.contains("CM"))
            countC -=2;
        if(s.contains("XL"))
            countX -=2;
        if(s.contains("XC"))
            countX -=2;
        if(s.contains("IV"))
            countI -=2;
        if(s.contains("IX"))
            countI -=2;
        return countI * 1 + countV * 5 + countX * 10 + countL * 50 + countC * 100
                + countD * 500 + countM * 1000;
    }
    public int OtherSolution(String s){
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i = 0; i < s.length(); i++){
            int val = map.get(s.charAt(i));
            if(i == s.length() - 1 || map.get(s.charAt(i+1)) <= map.get(s.charAt(i)))
                res += val;
            else
                res -= val;
        }
        return res;
    }
}
