package JZOffer.E_DrawToVisualize;

/**
 * @Author: HongbinW
 * @Date: 2019/3/27 11:24
 * @Version 1.0
 * @Description:
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class M27_Mirror {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        Mirror(root.left);
        Mirror(root.right);
    }
}
