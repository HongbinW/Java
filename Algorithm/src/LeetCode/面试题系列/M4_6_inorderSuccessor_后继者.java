package LeetCode.面试题系列;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M4_6_inorderSuccessor_后继者 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(inorderSuccessor(root, root).val);
    }
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    static TreeNode pre = null;
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null){
            return null;
        }
        TreeNode res = inorderSuccessor(root.left,p);
        if (res != null){
            return res;
        }
        if (pre == p){
            return root;
        }
        pre = root;
        res = inorderSuccessor(root.right,p);
        if (res != null){
            return res;
        }
        return null;
    }
}
