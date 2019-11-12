package nowcode.LeetCode.middle;

import java.util.ArrayList;
//https://www.nowcoder.com/practice/f983806a2ecb4106a17a365a642a9632?tpId=46&tqId=29049&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
public class partition_全分割成回文串 {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        partitionHelp(res,list,s);
        return res;
    }
    public void partitionHelp(ArrayList<ArrayList<String>> res, ArrayList<String> list, String s){
        if (s == null || s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= s.length(); i ++){
            String subStr = s.substring(0,i);
            if (isPalindrome(subStr)){
                list.add(subStr);
                partitionHelp(res,list,s.substring(i));
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        if (s == null || s.length() == 0)
            return false;
        int middle = s.length() / 2;
        for (int i = 0; i < middle; i ++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        partition_全分割成回文串 test = new partition_全分割成回文串();
        ArrayList<ArrayList<String>> res = test.partition("aab");
        for (ArrayList<String> list : res){
            for (String str : list){
                System.out.print(str+ " ");
            }
            System.out.println();
        }
    }
}
