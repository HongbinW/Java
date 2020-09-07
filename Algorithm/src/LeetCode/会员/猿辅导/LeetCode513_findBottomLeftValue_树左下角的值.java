package LeetCode.会员.猿辅导;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/26
 */
public class LeetCode513_findBottomLeftValue_树左下角的值 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int findBottomLeftValue(TreeNode root) {
        process(root,1);
        return res;
    }
    int depth = 0;
    int res = -1;
    public void process(TreeNode root, int cur){
        if (root == null){
            return;
        }
        process(root.left, cur + 1);
        if (cur > depth){
            depth = cur;
            res = root.val;
        }
        process(root.right, cur + 1);
    }
}
