package LeetCode.casuallly;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/14
 */
public class LeetCode103_zigzagLevelOrder_蛇形遍历二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        new LeetCode103_zigzagLevelOrder_蛇形遍历二叉树().zigzagLevelOrder(root);
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> queue1 = new Stack<>();
        Stack<TreeNode> queue2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        queue1.push(root);
        boolean flag = true;
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            root = queue1.pop();
            list.add(root.val);
            if (flag){
                if (root.left != null){
                    queue2.push(root.left);
                }
                if (root.right != null){
                    queue2.push(root.right);
                }
            }else{
                if (root.right != null){
                    queue2.push(root.right);
                }
                if (root.left != null){
                    queue2.push(root.left);
                }
            }
            if (queue1.isEmpty()){
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                queue1 = queue2;
                queue2 = new Stack<>();
                flag = !flag;
            }
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
}
