import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
public class Test{
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode cur = null;
            if(l1.val < l2.val){
                cur = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                cur = new ListNode(l2.val);
                l2 = l2.next;
            }
            ListNode head = cur;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    cur.next = new ListNode(l1.val);
                    cur = cur.next;
                    l1 = l1.next;
                }else{
                    cur.next = new ListNode(l2.val);
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
            while(l1 != null){
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            }
            while(l2 != null){
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
            return head;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    public ListNode(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
}