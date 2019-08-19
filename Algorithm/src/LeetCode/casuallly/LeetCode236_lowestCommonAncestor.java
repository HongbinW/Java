//package LeetCode.casuallly;
//
///**
// * @Author: HongbinW
// * @Date: 2019/8/4 22:47
// * @Version 1.0
// * @Description:
// */
//public class LeetCode236_lowestCommonAncestor {
//    class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//    }
//
//    private boolean process(TreeNode root, TreeNode p, TreeNode q){
//        if (root == null){
//            return false;
//        }
//        if (root == p)
//        return process(root.left,p,q) || process(root.right,p,q);
//    }
//}
