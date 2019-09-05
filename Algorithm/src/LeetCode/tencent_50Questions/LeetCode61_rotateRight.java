package LeetCode.tencent_50Questions;

/**
 * @Author: HongbinW
 * @Date: 2019/9/3 12:10
 * @Version 1.0
 * @Description:
 */
public class LeetCode61_rotateRight {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (slow != null){
            count ++;
            slow = slow.next;
        }
        slow = head;
        k %= count;
        while (k >= 0){
            fast = fast.next;
            k --;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        ListNode cur = res;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new LeetCode61_rotateRight().rotateRight(node,2);
    }
}
