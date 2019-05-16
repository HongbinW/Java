package JZOffer.D_Robust;

public class M22_KthToTail {
    public static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode findKthToTail(ListNode head, int k){
        if(head == null || k < 1){
            return null;
        }
        ListNode fast = head;
        while(k-1 > 0){
            fast = fast.next;
            if(fast == null){
                return null;
            }
            k--;
        }
        while(fast.next != null){
            fast = fast.next;
            head = head.next;
        }
        return head;
    }

}
