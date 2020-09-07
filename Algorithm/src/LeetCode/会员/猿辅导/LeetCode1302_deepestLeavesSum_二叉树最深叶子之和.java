package LeetCode.会员.猿辅导;

import java.util.ArrayList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */
public class LeetCode1302_deepestLeavesSum_二叉树最深叶子之和 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int deepestLeavesSum(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        process(root, 1, list);
        return list.get(list.size()-1);
    }
    public void process(TreeNode root, int depth, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        if (depth == list.size()){
            list.set(list.size()-1, list.get(list.size()-1) + root.val);
        }else if (depth > list.size()){
            list.add(root.val);
        }
        process(root.left,depth+1,list);
        process(root.right,depth+1,list);
    }
}
