package LeetCode.tencent_50Questions;

/**
 * @Author: HongbinW
 * @Date: 2019/8/30 16:27
 * @Version 1.0
 * @Description:
 */
public class LeetCode235_lowestCommonAncestorBST {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //太慢！
    TreeNode res = new TreeNode(0);
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (p == null){
            return q;
        }else if (q == null){
            return p;
        }
        process(root,p,q);
        return res;
    }
    public TreeNode process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        int one = 0;
        if (root == p || root == q){
            one ++;
        }
        if(process(root.left,p,q) != null){
            one ++;
        }
        if(process(root.right,p,q) != null){
            one ++;
        }
        if (one >= 2){
            res = root;
        }else if (one == 1){
            return root;
        }
        return null;
    }
    //法二
    //递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor2(root.left,p,q);
        }else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor2(root.right,p,q);
        }else{
            return root;
        }
    }
    //法三
    //迭代
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q){
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }else if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(5);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);
        System.out.println(new LeetCode235_lowestCommonAncestorBST().lowestCommonAncestor2(node,node.left,node.left.right).val);
    }
}
