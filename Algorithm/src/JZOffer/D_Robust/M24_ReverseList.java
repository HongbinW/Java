package JZOffer.D_Robust;

public class M24_ReverseList {
    public static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        curNode.next = preNode;
        while(nextNode != null){
            preNode = curNode;
            curNode = nextNode;
            nextNode = curNode.next;
            curNode.next = preNode;
        }
        return curNode;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reverseList(node);
    }

}
