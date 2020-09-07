package LeetCode.会员.猿辅导;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/26
 */
public class LeetCode86_partition_分隔链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode lessCur = less;
        ListNode more = new ListNode(0);
        ListNode moreCur = more;
        while (head != null){
            if (head.val < x){
                lessCur.next = new ListNode(head.val);
                lessCur = lessCur.next;
            }else{
                moreCur.next = new ListNode(head.val);
                moreCur = moreCur.next;
            }
            head = head.next;
        }
        lessCur.next = more.next;
        return less.next;
    }
}
