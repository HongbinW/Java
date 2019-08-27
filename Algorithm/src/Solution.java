
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.

import java.util.*;

class Solution {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curTotal = 1;
        int nextTotal = 0;
        while (!queue.isEmpty()){
            for (int i = 0 ; i < curTotal; i ++) {
                root = queue.poll();
                temp.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                    nextTotal++;
                }
                if (root.right != null) {
                    queue.offer(root.right);
                    nextTotal++;
                }
            }
            curTotal = nextTotal;
            res.add(new ArrayList<>(temp));
            temp = new ArrayList<>();
            nextTotal = 0;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}