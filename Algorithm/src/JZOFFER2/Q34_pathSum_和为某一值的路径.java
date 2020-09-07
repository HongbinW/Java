package JZOFFER2;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}
public class Q34_pathSum_和为某一值的路径 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new Q34_pathSum_和为某一值的路径().new Solution().pathSum(root,3);
    }

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            process(root,res,list,0,sum);
            return res;
        }
        public void process(TreeNode root, List<List<Integer>> res, List<Integer> list, int cur, int sum){
            if(root == null) {
                return;
            }
            cur += root.val;
            list.add(root.val);
            if(cur == sum && root.left == null && root.right == null){
                res.add(new ArrayList<>(list));
            }
            process(root.left,res,list,cur,sum);
            process(root.right,res,list,cur,sum);
            list.remove(list.size()-1);
        }
    }
}
