package LeetCode.casuallly;

public class LeetCode110_isBalanced {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isBalanced(TreeNode root) {
        return getDiff(root) != -1;
    }
    private int getDiff(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getDiff(root.left);
        if (left == -1){
            return -1;
        }
        int right = getDiff(root.right);
        if (right == -1){
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(left,right)+1;
    }


    public boolean isBalanced2(TreeNode root) {
        process(root);
        return flag;
    }
    boolean flag = true;
    public int process(TreeNode root){
        if (root == null || !flag){
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        if (Math.abs(left-right) > 1){
            flag = false;
        }
        return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(4);
        System.out.println(new LeetCode110_isBalanced().isBalanced(node));
    }
}
