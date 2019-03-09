/**
 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
/*
tips:
    正数的补码就是其本身
    负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)

    正数的反码是他原码
    负数的反码是在其原码的基础上, 除了符号位数不变，其余位取反.
 */
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Test{
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode pnext = null;
        while(head != null) {
            pnext = head.next;
            head.next = prev;
            prev = head;
            head = pnext;
        }
        return head;
    }
}