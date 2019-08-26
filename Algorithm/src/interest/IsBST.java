package interest;

/**
 * @Author: HongbinW
 * @Date: 2019/8/26 23:11
 * @Version 1.0
 * @Description:
 */
public class IsBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        //要设置最大值和最小值
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isBST(TreeNode root,long min,long max)
    {
        if(root==null)
            return true;
        if(root.val<=min||root.val>=max)
        {
            return false;
        }
        //左子树，要改变上限，右子树要改变下限。
        return isBST(root.left,min,root.val)&&isBST(root.right,root.val,max);
    }
}
