package LeetCode.面试题系列;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M4_5_isValidBST_判断是否为二叉搜索树 {
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                if (root.val <= pre){
                    return false;
                }
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }
}
