package JZOffer.J_knowledgeTransfer;

public class M55_Q2_IsBalancedTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //无OJ
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int left = getDepth(root.left,0);
        int right = getDepth(root.right,0);
        if(Math.abs(left-right) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int getDepth(TreeNode node, int depth){
        if(node == null){
            return depth;
        }
        return Math.max(getDepth(node.left,depth+1),getDepth(node.right,depth+1));
    }

    //法二：更佳，这样避免了重复计算。即先遍历子节点，如果子节点不平衡，则返回-1，否则继续遍历
    // OJ结果差不多？？？？？？？
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
