package LeetCode.会员.猿辅导;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/26
 */
public class LeetCode114_flatten_二叉树转链表 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        new LeetCode114_flatten_二叉树转链表().flatten(root);
    }
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (pre != null){
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        pre.left = null;        //防止成环
        pre.right = null;
        flatten(left);
        flatten(right);
    }
}
