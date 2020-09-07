package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/18
 */
// 每个节点代表一位数，求所有根节点到叶子节点组成的数之和
public class LeetCode129_sumNumbers_根到叶子数字和 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  int res = 0;
    public int sumNumbers(TreeNode root) {
        process(root,0);
        return res;
    }
    public void process(TreeNode root, int cur){
        if (root == null){
            return;
        }
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null){
            res += cur;
        }
        process(root.left,cur);
        process(root.right,cur);
    }
}
