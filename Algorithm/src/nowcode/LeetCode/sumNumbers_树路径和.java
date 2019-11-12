package nowcode.LeetCode;

public class sumNumbers_树路径和 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        sumHelp(root,0,0);
        return xxx;
    }
    int xxx = 0;
    public void sumHelp(TreeNode root, int depth, int cur){
        int res = root.val + cur * 10;
        if (root.left == null && root.right == null){
            xxx += res;
        }
        if (root.left != null) {
            sumHelp(root.left,depth+1,res);
        }
        if (root.right != null){
            sumHelp(root.right,depth+1,res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        System.out.println(new sumNumbers_树路径和().sumNumbers(root));
    }
}
