package LeetCode.会员.拼多多;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/2
 */
public class LeetCode143_reorderList_重排链表_一头一尾 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public void reorderList(ListNode head) {
        ListNode cur = head;
        int total = 0;
        while (cur != null){
            total ++;
            cur = cur.next;
        }
        if (total < 2){
            return;
        }
        int mid = (total - 1) / 2;
        ListNode fast = head;
        while (mid > 0){
            fast = fast.next;
            mid --;
        }
        ListNode pre = fast;
        cur = fast.next;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        fast.next = null;
        ListNode left = head;
        ListNode right = pre;
        while (left != right && right.next != left){
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
        if (left != right){
            left.next = right;
            right.next = null;
        }
    }
}
