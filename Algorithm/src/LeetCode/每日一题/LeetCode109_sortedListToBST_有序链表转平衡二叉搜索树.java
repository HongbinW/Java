package LeetCode.每日一题;

import java.util.ArrayList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/18
 */
public class LeetCode109_sortedListToBST_有序链表转平衡二叉搜索树 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        //[-10,-3,0,5,9]
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        new LeetCode109_sortedListToBST_有序链表转平衡二叉搜索树().sortedListToBST(head);

    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return process(list, 0, list.size());
    }
    public TreeNode process(ArrayList<ListNode> list, int left, int right){
        if (left > right){
            return null;
        }
        if (left == right){
            return new TreeNode(list.get(left).val);
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(list.get(mid).val);
        node.left = process(list,left, mid - 1);
        node.right = process(list, mid + 1, right);
        return node;
    }
}
