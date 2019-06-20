package LeetCode.Hot100;

import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/6/20 22:10
 * @Version 1.0
 * @Description:
 */
public class LeetCode583_convertBST {
      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }
    public TreeNode convertBST(TreeNode root) {
          if (root == null){
              return null;
          }
        //从当前节点中序遍历累加
        Stack<TreeNode> stack = new Stack<>();
        inOrder(stack,root);
        int preNum = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            node.val += preNum;
            preNum = node.val;
        }
        return root;
    }

    public void inOrder(Stack<TreeNode> stack, TreeNode root){
          Stack<TreeNode> temp = new Stack<>();
          while (root != null || !temp.isEmpty()){
              if (root != null){
                  temp.add(root);
                  root = root.left;
              }else{
                  root = temp.pop();
                  stack.add(root);
                  root = root.right;
              }
          }
    }

    //法二
    public TreeNode convertBST2(TreeNode root) {
        process(root);
        return root;
    }
    int preValue;
    public void process(TreeNode root){
          if (root == null){
              return;
          }
          process(root.right);
          root.val +=  preValue;
          preValue = root.val;
          process(root.left);
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(13);

        LeetCode583_convertBST test = new LeetCode583_convertBST();
        test.convertBST2(node);
    }
}
