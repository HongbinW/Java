package LeetCode.会员.猿辅导;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */
public class LeetCode1038_bstToGst_二叉树转更大和数 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode bstToGst(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode head = root;
        Stack<TreeNode> stack = new Stack<>();
        int pre = 0;
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.right;
            }else{
                root = stack.pop();
                root.val += pre;
                pre = root.val;
                root = root.left;
            }
        }
        return head;
    }
}
