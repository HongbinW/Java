package JZOffer.D_Robust;

public class M25_MergeList {
    public static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }
    public ListNode mergeList(ListNode head1,ListNode head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        ListNode mergeHead = null;
        if(head1.value > head2.value){
            mergeHead = head2;
            mergeHead.next = mergeList(head1,head2.next);
        }else{
            mergeHead = head1;
            mergeHead.next = mergeList(head1.next,head2);
        }
        return mergeHead;
    }
}
