package LeetCode.casuallly;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/4/22
 */
public class LeetCode199_rightSideView_二叉树右视图 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.get(5));
    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        process(root,list,0);
        return list;
    }
    private void process(TreeNode root, ArrayList<Integer> list, int depth){
        if (root == null){
            return;
        }
        if (list.size() - 1 < depth){
            list.add(root.val);
        }
        if (root.right != null){
            process(root.right,list,depth+1);
        }
        if (root.left != null){
            process(root.left,list,depth+1);
        }
    }
}
