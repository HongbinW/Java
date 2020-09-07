package LeetCode.会员.猿辅导;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */
public class LeetCode445_addTwoNumbers_链表相加_正序 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        Stack<Integer> stack = new Stack<>();
        int c = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int cur = c + stack1.pop().val + stack2.pop().val;
            stack.push(cur % 10);
            c = cur / 10;
        }
        while (!stack1.isEmpty()){
            int cur = c + stack1.pop().val;
            stack.push(cur % 10);
            c = cur / 10;
        }
        while (!stack2.isEmpty()){
            int cur = c + stack2.pop().val;
            stack.push(cur % 10);
            c = cur / 10;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        if (c != 0){
            cur.next = new ListNode(c);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return head.next;
    }
}
