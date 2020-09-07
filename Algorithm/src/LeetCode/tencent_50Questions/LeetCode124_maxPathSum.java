package LeetCode.tencent_50Questions;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/8/30 20:14
 * @Version 1.0
 * @Description:
 */
public class LeetCode124_maxPathSum {
    static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum2(TreeNode root) {
        max_gain(root);
        return max_sum;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);

        System.out.println(new LeetCode124_maxPathSum().maxPathSum2(node));
    }


    // 拓展，最大路径和的路径
    List<TreeNode> res = new ArrayList<>() ;
    int max = Integer.MIN_VALUE;
    public List<TreeNode> maxSumPath(TreeNode root) {
        process(root);
        return res;
    }
    public List<TreeNode> process(TreeNode root){       // 从左右分别取出当前的最大List
        if (root == null){
            return new ArrayList<>();
        }
        List<TreeNode> left = process(root.left);
        List<TreeNode> right = process(root.right);
        int leftSum = 0, rightSum = 0;
        for (TreeNode node : left){
            leftSum += node.val;
        }
        for (TreeNode node : right){
            rightSum += node.val;
        }
        ArrayList<TreeNode> cur = new ArrayList<>();
        if (leftSum < 0){
            leftSum = 0;
            left = new ArrayList<>();
        }
        if (rightSum < 0){
            rightSum = 0;
            right = new ArrayList<>();
        }

        if (leftSum + rightSum + root.val > max){   // 如果大于max，则记录
            max = leftSum + rightSum + root.val;
            res = new ArrayList<>();
            res.addAll(left);
            res.addAll(right);
            res.add(root);
        }
        cur.add(root);
        if (leftSum > rightSum){        // 选root，然后左右选一边继续向上递归
            cur.addAll(left);
        }else if (leftSum < rightSum){
            cur.addAll(right);
        }
        return cur;
    }
}
