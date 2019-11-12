package nowcode.LeetCode.easy;

public class reorderList_一头一尾 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        fast = head;
        int i = 0;
        while (fast != null && pre != null){
            if (i % 2 != 0){
                fast = fast.next;
            }else{
                slow = pre;
                pre = pre.next;
                slow.next = fast.next;
                fast.next = slow;
                fast = fast.next;
            }
            i ++;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(-1);
        head.next.next = new ListNode(-6);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(8);
        new reorderList_一头一尾().reorderList(head);

    }
}
