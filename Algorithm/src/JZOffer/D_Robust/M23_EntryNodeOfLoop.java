package JZOffer.D_Robust;

public class M23_EntryNodeOfLoop {
    public static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode entryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null || pHead.next.next == null)
            return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while(fast != slow){
            if(fast == null || fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
