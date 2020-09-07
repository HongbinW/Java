package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/14
 */
public class M0205_addTwoNumbers_链表求和 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    // 链表反向。 即 345  node：5->4->3
    int c = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            if (c != 0){
                return new ListNode(c);
            }
            return null;
        }
        int num1 = 0, num2 = 0;
        if (l1 != null){
            num1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null){
            num2 = l2.val;
            l2 = l2.next;
        }
        int sum = num1 + num2 + c;
        c = sum / 10;
        ListNode node =  new ListNode(sum%10);
        node.next = addTwoNumbers(l1, l2);
        return node;
    }
}
