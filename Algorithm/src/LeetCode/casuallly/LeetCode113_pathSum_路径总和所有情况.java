package LeetCode.casuallly;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/18
 */
public class LeetCode113_pathSum_路径总和所有情况 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        process(res,list,root,sum);
        return res;
    }
    public void process(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum){
        if (root == null){
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        process(res,list,root.left,sum);
        process(res,list,root.right,sum);
        list.remove(list.size()-1);
    }
}
