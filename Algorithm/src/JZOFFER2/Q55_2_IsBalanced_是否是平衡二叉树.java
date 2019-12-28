package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2019/12/15
 */
public class Q55_2_IsBalanced_是否是平衡二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isBalanced(TreeNode root){
        return process(root) != -1;
    }
    public int process(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = process(root.left);
        if (left == -1)
            return -1;
        int right = process(root.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
