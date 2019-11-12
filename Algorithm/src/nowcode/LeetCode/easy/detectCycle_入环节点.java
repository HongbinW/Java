package nowcode.LeetCode.easy;

public class detectCycle_入环节点 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow){
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return null;
            }
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow){
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return false;
            }
        }
        return true;
    }
}
