package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/18
 */
public class LeetCode112_hasPathSum_路径总和 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
}
