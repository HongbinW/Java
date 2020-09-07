package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/15
 */
public class LeetCode109_sortedListToBST_有序链表转二叉搜索树 {
    public static void main(String[] args) {
        int[] arr = new int[]{-10, -3, 0, 5, 9};
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        sortedListToBST(head);

    }
   static   class ListNode {
     int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;    //断开pre和slow
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null){
            pre.next = null;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        if (head != slow)
            root.left = sortedListToBST(head);
        return root;
    }
}
