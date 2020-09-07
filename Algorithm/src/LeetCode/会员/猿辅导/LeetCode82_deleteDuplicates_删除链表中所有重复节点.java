package LeetCode.会员.猿辅导;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */
public class LeetCode82_deleteDuplicates_删除链表中所有重复节点 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode pre = res;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            if (next == null){
                pre.next = cur;
            } else if (cur.val != next.val){
                pre.next = cur;
                pre = cur;
            }else{
                while (next != null && cur.val == next.val){
                    next = next.next;
                }
                if (next == null){      //如果直接走到了最后，要让pre.next直接指向最后
                    pre.next = null;
                }
            }
            cur = next;
        }
        return res.next;
    }

}
