package JZOffer.J_knowledgeTransfer;

public class M55_Q1_TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return process(root,1);
    }

    public int process(TreeNode node, int depth){
        if(node == null){
            return depth;
        }
        return Math.max(process(node.left,depth+1),process(node.right,depth+1));
    }


}
