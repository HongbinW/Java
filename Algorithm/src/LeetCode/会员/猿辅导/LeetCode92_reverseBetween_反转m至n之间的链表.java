package LeetCode.会员.猿辅导;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/26
 */
public class LeetCode92_reverseBetween_反转m至n之间的链表 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new LeetCode92_reverseBetween_反转m至n之间的链表().reverseBetween(head,2,4);    //从1开始数
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode start = head;
        while (m > 1){
            pre = start;
            start = start.next;
            m --;
            n --;
        }
        ListNode end = start;
        ListNode tmpPre = null;
        while (n > 1){
            ListNode next = end.next;
            end.next = tmpPre;
            tmpPre = end;
            end = next;
            n --;
        }
        if (end == start){
            return head;
        }else {
            start.next = end.next;
            end.next = tmpPre;
        }
        if (pre != null) {
            pre.next = end;
            return head;
        }else{              // 如果pre == null，说明是从第一个节点开始的
            return end;
        }
    }
}
