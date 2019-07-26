package LeetCode.explore_byteDance.String;

public class Q5_reverseWords {
    public String reverseWords(String s) {
        if(s == null){
            return null;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1 ; i >= 0 ; i --){
            if(strs[i].equals(""))
                continue;
            sb.append(strs[i] + " ");
        }
        return sb.toString().trim();
    }
}
