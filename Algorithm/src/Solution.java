
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.

import java.util.Stack;

class Solution {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int temp = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                if (temp >= root.val){
                    return false;
                }
                temp = root.val;
                root = root.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);
        System.out.println(isValidBST(node));
    }
}