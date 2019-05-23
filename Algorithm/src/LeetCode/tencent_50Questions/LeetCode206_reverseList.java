package LeetCode.tencent_50Questions;

public class LeetCode206_reverseList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //法一：
    public ListNode reverseList1(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

}
