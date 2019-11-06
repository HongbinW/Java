package nowcode.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class postorderTraversal_后序遍历二叉树 {
    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<Integer> tmp = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            tmp.push(root.val);
            if (root.left != null){
                stack.push(root.left);
            }
            if (root.right != null){
                stack.push(root.right);
            }
        }

        while (!tmp.isEmpty()){
            list.add(tmp.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> list = new postorderTraversal_后序遍历二叉树().postorderTraversal(root);
        for (int i : list){
            System.out.println(i);
        }
    }
}
