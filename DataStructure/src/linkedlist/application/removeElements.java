package linkedlist.application;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    //链表节点的构造函数
    //使用arr为参数，创建一个链表，当前的ListNode为链表头结点
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

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if(head == null){
            return null;
        }
        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }
}

class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    //LeetCode中对于链表题生成测试用例
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,1,4,2,1,4,2,1};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        Solution2 s = new Solution2();
        System.out.println(s.removeElements(head,1));
    }
}