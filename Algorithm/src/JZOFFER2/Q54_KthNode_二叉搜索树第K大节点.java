package JZOFFER2;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2019/12/14
 */
public class Q54_KthNode_二叉搜索树第K大节点 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        int num = 0;
        while (!stack.isEmpty() || pRoot != null){
            if (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }else{
                pRoot = stack.pop();
                num ++;
                if (num == k){
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
