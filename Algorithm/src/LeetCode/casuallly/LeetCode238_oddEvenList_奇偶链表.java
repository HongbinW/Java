package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/5
 */

// 奇数位置在前，偶数位置在后
public class LeetCode238_oddEvenList_奇偶链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenCur = even;
        while (head.next != null && evenCur.next != null){
            head.next = head.next.next;
            head = head.next;
            evenCur.next = head.next;
            evenCur = evenCur.next;
        }
        head.next = even;
        return odd;
    }
}
