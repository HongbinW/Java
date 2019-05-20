package JZOffer.F_abstractToSpecific;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class M37_SerializeAndDeserilize {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static String  Serialize(TreeNode root) {
        String res = "";
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null) {
                res += node.val + ",";
                stack.push(node.right);
                stack.push(node.left);
            }else{
                res += "$,";
            }
        }
        return res.substring(0,res.length()-1);
    }
    static TreeNode Deserialize(String str) {
        String[] strs = str.split(",");
        Queue<String> queue = new LinkedList<>();
        for(String ele : strs){
            queue.offer(ele);
        }
        return process(queue);
    }
    private static TreeNode process(Queue<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        String ele = queue.poll();
        if(ele.equals("$")){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(ele));
            node.left = process(queue);
            node.right = process(queue);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(6);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(8);
        node.right = new TreeNode(14);
        node.right.left = new TreeNode(12);
        node.right.right = new TreeNode(16);
        String str = Serialize(node);
        Deserialize(str);
    }
}
