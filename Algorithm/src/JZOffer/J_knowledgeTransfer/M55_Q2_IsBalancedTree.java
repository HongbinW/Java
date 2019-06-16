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

    public static class Structure{
        boolean flag;
        int depth;

        public Structure(boolean flag,int depth){
            this.flag = flag;
            this.depth = depth;
        }
    }

    public Structure isBalanced(TreeNode root, int depth){
        if(root == null){
            return new Structure(true,0);
        }
        Structure left = isBalanced(root.left,0);
        Structure right = isBalanced(root.right,0);
        if (left.flag && right.flag){
            int diff = Math.abs(left.depth-right.depth);
            if(diff <= 1){
                return new Structure(true,Math.max(left.depth,right.depth)+ 1);
            }
        }
        return new Structure(false,-1);
    }
}
