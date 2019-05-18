package JZOffer.F_abstractToSpecific;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class M34_FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //层序便利二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            //问题：怎么最有效地保存之前的结果
        }
        return res;
    }
}
