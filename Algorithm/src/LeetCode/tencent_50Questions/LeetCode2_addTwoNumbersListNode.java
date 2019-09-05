package LeetCode.tencent_50Questions;

/**
 * @Author: HongbinW
 * @Date: 2019/9/2 11:12
 * @Version 1.0
 * @Description:
 */
public class LeetCode2_addTwoNumbersListNode {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int c = 0;
        ListNode res = l1;
        ListNode cur = l1;
        while (l1 != null && l2 != null){
            int temp = l1.val + l2.val + c;
            l1.val = temp % 10;
            c = temp / 10;
            cur = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int temp = l1.val + c;
            cur.next = new ListNode(temp % 10);
            c = temp / 10;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int temp = l2.val + c;
            cur.next = new ListNode(temp % 10);
            c = temp / 10;
            cur = cur.next;
            l2 = l2.next;
        }
        if (c != 0){
            cur.next = new ListNode(c);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(9);
        ListNode node2 = new ListNode(2);
        ListNode res = new LeetCode2_addTwoNumbersListNode().addTwoNumbers(node1,node2);
    }
}
