package LeetCode.面试题系列;

import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M2_4_partition_分割链表 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode less = res;
        ListNode moreHead = new ListNode(0);
        ListNode more = moreHead;

        while (head != null){
            if (head.val >= x){
                more.next = head;
                more = more.next;
            }else{
                less.next = head;
                less = less.next;
            }
            head = head.next;
        }
        more.next = null;
        less.next = moreHead.next;
        return res.next;
    }
}
