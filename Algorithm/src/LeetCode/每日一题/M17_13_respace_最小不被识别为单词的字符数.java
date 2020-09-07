package LeetCode.每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/9
 */
public class M17_13_respace_最小不被识别为单词的字符数 {
    public static void main(String[] args) {
        String[] strs = new String[]{"looked","just","like","her","brother"};
        String sen = "jesslookedjustliketimherbrother";
        System.out.println(new Solution().respace(strs,sen));
    }

    // 超时了
    public static int respaceWrong(String[] dictionary, String sentence) {
        if (sentence.length() == 0){
            return 0;
        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (String str : dictionary){
            if (sentence.startsWith(str)){
                min = Math.min(min, respaceWrong(dictionary,sentence.substring(str.length())));
            }
        }
        if (min == Integer.MAX_VALUE){
            count ++;
            return 1 + respaceWrong(dictionary,sentence.substring(1));
        }
        return min;
    }

    // 70/71  没全过
    public static int respace(String[] dictionary, String sentence) {
        HashSet<String> set = new HashSet<>();
        for (String str : dictionary){
            set.add(str);
        }
        int[] dp = new int[sentence.length()+1];
        for (int i = 1; i < dp.length; i ++){
            int cur = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j --){
                if (set.contains(sentence.substring(j,i))){
                    cur = Math.min(cur, dp[j]);
                }
            }
            if (cur == Integer.MAX_VALUE){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = cur;
            }
        }
        return dp[dp.length-1];
    }


    // 官方 字典树
    // 字典中都倒序建树
    // 如果有一段字符没走到根节点，那就直接跳出循环，说明这段不可能了
    static class Solution {
        public static int respace(String[] dictionary, String sentence) {
            int n = sentence.length();

            Trie root = new Trie();
            for (String word: dictionary) {
                root.insert(word);
            }

            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; ++i) {
                dp[i] = dp[i - 1] + 1;

                Trie curPos = root;
                for (int j = i; j >= 1; --j) {
                    int t = sentence.charAt(j - 1) - 'a';
                    if (curPos.next[t] == null) {       // 如果不在字典树中，则直接返回，即dp[i] = dp[i-1]+1
                        break;
                    } else if (curPos.next[t].isEnd) {
                        dp[i] = Math.min(dp[i], dp[j - 1]);
                    }
                    curPos = curPos.next[t];
                }
            }
            return dp[n];
        }
    }

    static class Trie {
        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie curPos = this;

            for (int i = s.length() - 1; i >= 0; --i) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }



}
