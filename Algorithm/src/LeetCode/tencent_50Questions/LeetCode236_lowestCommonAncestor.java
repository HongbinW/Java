package LeetCode.tencent_50Questions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/8/31 15:56
 * @Version 1.0
 * @Description:
 */
public class LeetCode236_lowestCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        process(root,p,q);
        return res;
    }
    private TreeNode process(TreeNode root,TreeNode p,TreeNode q){
        if (root == null){
            return null;
        }
        int one = 0;
        if (root == p || root == q){
            one ++;
        }
        if (process(root.left,p,q) != null){
            one ++;
        }
        if (process(root.right,p,q) != null){
            one ++;
        }
        if (one >= 2){
            res = root;
        }else if (one == 1){
            return root;
        }
        return null;
    }

    //法二：先分别找到p和q，返回其路径List1和List2，然后跟找入环节点一样，顺着找到一个重合节点。
    //这样好像比我这个快
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        path1.add(root);
        getPath(root, p, path1);

        List<TreeNode> path2 = new ArrayList<>();
        path2.add(root);
        getPath(root, q, path2);

        int size = path1.size() < path2.size() ? path1.size() : path2.size();
        TreeNode n1 = root;
        TreeNode n2 = root;
        TreeNode res = root;
        int i = 0;
        while(i < size) {
            n1 = path1.get(i);
            n2 = path2.get(i);
            if ( n1 == n2) {
                res = n1;
            } else {
                break;
            }
            i++;
        }
        return res;
    }

    private boolean getPath(TreeNode node, TreeNode target, List<TreeNode> path) {
        if (node == target) {
            return true;
        }

        if (node.left != null) {
            path.add(node.left);
            if (getPath(node.left, target, path)) {
                return true;
            }
            path.remove(node.left);
        }

        if (node.right != null) {
            path.add(node.right);
            if (getPath(node.right, target, path)) {
                return true;
            }
            path.remove(node.right);
        }

        return false;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;     // 如果能找到p或者q会返回p或q，否则肯定会返回Null
        TreeNode left = lowestCommonAncestor3(root.left, p ,q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        //if left == null 说明左边既不包含p也不包含q
        //if right  == null , 说明右边也都不包含 return null
        //if right = p or q  返回p or q
        //同理 right == null
        //如果左右都不为空， root就是祖先
        if(left == null) return right;
        if(right == null) return left;
        return root;
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
        System.out.println(new LeetCode236_lowestCommonAncestor().lowestCommonAncestor(node, node.left, node.left.right.right).val);
    }

    // 优秀解

    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {

        if(root == p || root == null || root == q){
            return root;
        }

        TreeNode A = lowestCommonAncestor4(root.left,p,q);
        TreeNode B = lowestCommonAncestor4(root.right,p,q);

        // 如果有一边为null，说明那一边p,q都没有，所以返回一边就行
        if(A ==null){
            return B;
        }

        if(B ==null){
            return A;
        }

        if(A != null && B!= null){
            return root;
        }
        return null;
    }
}
