package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/14
 */
public class LeetCode25_reverseKGroup_k个一组翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode res = reverseKGroup(head,2);
        while (res != null){
            System.out.printf("%d ",res.val);
            res = res.next;
        }
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1){
            return head;
        }
        ListNode pre = null;
        ListNode newHead = null;
        ListNode start = head;
        ListNode end = head;
        while (end != null){
            int count = k;
            while (end != null &&count > 0){
                end = end.next;
                count --;
            }
            if (count == 0) {
                ListNode tmpPre = null;
                ListNode cur = start;
                while (cur != end) {
                    ListNode tmpNext = cur.next;
                    cur.next = tmpPre;
                    tmpPre = cur;
                    cur = tmpNext;
                }
                if (pre == null) {
                    newHead = tmpPre;
                } else {
                    pre.next = tmpPre;
                }
                pre = start;
                start = end;
            }else if (pre != null){
                pre.next = start;
            }else{
                newHead = start;
            }
        }
        return newHead;
    }

}
