package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2019/12/14
 */
public class Q55_DepthOfTree_二叉树深度 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    int maxDepth = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        process(root,0);
        return maxDepth;
    }
    public void process(TreeNode root, int depth){
        if (root == null){
            return;
        }
        maxDepth = Math.max(maxDepth,depth);
        if (root.left != null){
            process(root.left,depth + 1);
        }
        if (root.right != null){
            process(root.right,depth+1);
        }
    }

    public int TreeDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        return process1(root,1);
    }

    public int process1(TreeNode node, int depth){
        if(node == null){
            return depth;
        }
        return Math.max(process1(node.left,depth+1),process1(node.right,depth+1));
    }
}
