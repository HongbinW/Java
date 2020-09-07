package JZOffer.A_dataStructure;

import java.util.ArrayList;

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
    private class Q {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<>();
            while(listNode != null){
                list.add(listNode.val);
                listNode = listNode.next;
            }
            reverse(list);
            return list;
        }
        public void reverse(ArrayList<Integer> list){
            for(int i = 0; i < list.size()/2; i ++){
                int temp = list.get(i);
                list.set(i,list.get(list.size()-1-i));
                list.set(list.size()-1-i,temp);
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{67,0,24,58};
        ListNode node = new ListNode(nums);
//        new M6_PrintListReversingly().new Q().PrintListReversingly(node);
        new M6_PrintListReversingly().new Q().printListFromTailToHead(node);
    }
}
