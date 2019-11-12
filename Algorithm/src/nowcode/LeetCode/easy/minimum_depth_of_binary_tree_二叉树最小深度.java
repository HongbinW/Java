package nowcode.LeetCode.easy;

import java.util.LinkedList;
import java.util.Queue;
//https://www.nowcoder.com/practice/e08819cfdeb34985a8de9c4e6562e724?tpId=46&tqId=29030&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class minimum_depth_of_binary_tree_二叉树最小深度 {
    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 1;
        int cur = 1;
        int next = 0;
        while (!queue.isEmpty()){
            root = queue.poll();
            cur  --;
            if (root.left == null && root.right == null){
                return res;
            }
            if (root.left != null){
                queue.add(root.left);
                next ++;
            }
            if (root.right != null){
                queue.add(root.right);
                next ++;
            }
            if (cur == 0){
                cur = next;
                next = 0;
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
//        node.right = new TreeNode(4);
        node.left = new TreeNode(2);
//        node.left.right = new TreeNode(3);
        System.out.println(new minimum_depth_of_binary_tree_二叉树最小深度().run(node));
    }
}
