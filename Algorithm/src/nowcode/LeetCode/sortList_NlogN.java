package nowcode.LeetCode;
//https://www.nowcoder.com/practice/d75c232a0405427098a8d1627930bea6?tpId=46&tqId=29033&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
public class sortList_NlogN {
    static class ListNode {
        int val;
         ListNode next;
         ListNode(int x) {
            val = x;
            next = null;
         }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        right = sortList(right);
        return merge(left,right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (left != null && right != null){
            if (left.val <= right.val){
                cur.next = left;
                left = left.next;
                cur = cur.next;
            }else {
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }
        cur.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(-1);
        head.next.next = new ListNode(-6);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(9);
        ListNode res = new sortList_NlogN().sortList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
