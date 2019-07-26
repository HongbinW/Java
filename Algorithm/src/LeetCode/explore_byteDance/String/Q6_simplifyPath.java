package LeetCode.explore_byteDance.String;

import java.util.LinkedList;

public class Q6_simplifyPath {
    public String simplifyPath(String path) {
        LinkedList<String> queue = new LinkedList<>();
        String[] strs = path.split("/");
        for (int i = 0; i < strs.length; i ++) {
            if (strs[i].equals("") || strs[i].equals("."))
                continue;
            if (strs[i].equals("..") && !queue.isEmpty()) {
                queue.pollLast();
            }
            if(!strs[i].equals("..")){
                queue.addLast(strs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (queue.isEmpty()){
            return "/";
        }
        while (!queue.isEmpty()) {
            sb.append("/");
            sb.append(queue.pop());
        }
        return sb.toString();
    }
}
