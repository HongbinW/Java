package goodQuestion.tree;

/**
 * @Author: HongbinW
 * @Date: 2019/9/5 12:11
 * @Version 1.0
 * @Description:
 */
public class treeToLinkedList_LeetCode114_将树转化为链表 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //解法一：将所有的左子树放到右子树位置上，并把原来的右子树接到当前右子树的最右边节点的位置
    public void flatten(TreeNode root) {
        while (root != null){
            if (root.left == null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }


    //解法二：后续遍历
    private TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
