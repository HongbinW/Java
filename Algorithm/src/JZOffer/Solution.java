package JZOffer;

import java.util.ArrayList;

public class Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return res;
        }
        target -= root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null && target == 0){
            res.add(new ArrayList<>(temp));
        }else{
            FindPath(root.left,target);
            FindPath(root.right,target);
        }
        temp.remove(temp.size()-1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        new Solution().FindPath(node,22);
    }


    public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null){
                return false;
            }
            sum -= root.val;
            if(root.left == null && root.right == null && sum == 0){
                return true;
            }else{
                return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
            }
        }
    }
}
