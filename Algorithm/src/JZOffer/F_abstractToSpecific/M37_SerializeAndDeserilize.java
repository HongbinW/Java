package JZOffer.F_abstractToSpecific;

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
    String Serialize(TreeNode root) {
        String res = "";
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            stack.push(node.right);
            stack.push(node.right);
            if(node != null) {
                res += node.val + ",";
            }else{
                res += "$,";
            }
        }
        return res.substring(0,res.length()-1);
    }
    TreeNode Deserialize(String str) {
        if(str.equals(""))
            return null;
        String[] strs = str.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(strs[0]));
        TreeNode node = head;
        for(int i = 1; i < strs.length; i++){

        }
    }
}
