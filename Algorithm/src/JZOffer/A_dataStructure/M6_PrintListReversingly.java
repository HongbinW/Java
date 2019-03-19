package JZOffer.A_dataStructure;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    public ListNode(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
}
public class M6_PrintListReversingly {
    private class Q{
        public void PrintListReversingly(ListNode head){
            if(head == null){
                return;
            }
            ListNode prev = null;
            while(head.next != null){
                ListNode pnext = head.next;
                head.next = prev;
                prev = head;
                head = pnext;
            }
            head.next = prev;
            while(head != null){
                System.out.print(head.val + " -> ");
                head = head.next;
            }
            System.out.println("NULL");
        }
        public void PrintListReversingly_DiGui(ListNode head){
            if(head == null)
                return;
            else{
                PrintListReversingly_DiGui(head.next);
                System.out.print(head.val + " -> ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        ListNode node = new ListNode(nums);
//        new M6_PrintListReversingly().new Q().PrintListReversingly(node);
        new M6_PrintListReversingly().new Q().PrintListReversingly_DiGui(node);
    }
}
