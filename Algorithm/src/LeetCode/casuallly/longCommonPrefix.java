package easy;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/24
 */

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class longCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"bab","bcc"};
        String result = LongestCommonPrefix1(strs);
        System.out.println(result);
    }
    //法一：用时6ms
    public static String LongestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min = 0;
        for (int i = 0; i < strs.length; i++) {
            min = strs[min].length() > strs[i].length() ? i : min;
        }
        for (int i = 0; i < strs[min].length(); i++) {
            String res = strs[min].substring(0, strs[min].length() - i);
            int j = 0;
            while (strs[j].startsWith(res)) {
                j++;
                if (j == strs.length)
                    return res;
            }
        }

        return "";
    }

    //法二：用时9ms
    public static String LongestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min = 0;
        for (int i = 0; i < strs.length; i++) {
            min = strs[min].length() > strs[i].length() ? i : min;
        }
        for (int i = 0; i < strs[min].length(); i++) {
            int j = 0;
            while (strs[j].regionMatches(0,strs[min],0,strs[min].length() - i)) {
                j++;
                if(j == strs.length)
                    return strs[min].substring(0,strs[min].length() - i);
            }
        }
        return "";
    }
}
