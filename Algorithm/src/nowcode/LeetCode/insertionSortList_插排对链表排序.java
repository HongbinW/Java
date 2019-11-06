package nowcode.LeetCode;
// https://www.nowcoder.com/practice/152bc6c5b14149e49bf5d8c46f53152b?tpId=46&tqId=29034&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
public class insertionSortList_插排对链表排序 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = head;        //当前节点的其前一个节点
        ListNode cur = head.next;   //当前节点
        while (cur != null){
            ListNode ori = preHead.next;        //每次都从头往后找
            ListNode oriPre = preHead;     //寻找节点的前一个节点
            while (ori != cur){
                if (ori.val > cur.val) {
                    ListNode process = cur;
                    pre.next = process.next;
                    oriPre.next = process;
                    process.next = ori;
                    break;
                }else{
                    ori = ori.next;
                    oriPre = oriPre.next;
                }
            }
            if (ori == cur) {
                cur = pre.next.next;
                pre = pre.next;
            }
            else
                cur = pre.next;
        }
        return preHead.next;
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
        ListNode res = new insertionSortList_插排对链表排序().insertionSortList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode insertionSortList2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curNode = head.next;
        ListNode pNode = new ListNode(0);
        pNode.next = head;
        head.next = null;
        while(curNode != null){
            ListNode compareNode = pNode;
            while(compareNode != null){
                if(compareNode.next == null || compareNode.next.val>= curNode.val){
                    break;
                }
                compareNode = compareNode.next;
            }
            ListNode temp = curNode.next;
            curNode.next = compareNode.next;
            compareNode.next = curNode;
            curNode = temp;
        }
        return pNode.next;
    }
}
