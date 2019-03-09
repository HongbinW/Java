package digui;

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
//打印输出来调试递归可见Solution
class Solution3 {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
//        ListNode res = removeElements(head.next,val);
//        if(head.val  == val){
//            return res;
//        }else{
//            head.next = res;
//            return head;
//        }

        head.next = removeElements(head.next,val);  // 将问题不断化小
//        if(head.val == val){
//            return head.next;
//        }else{
//            return head;
//        }
        return head.val == val ? head.next : head;
    }
    //LeetCode中对于链表题生成测试用例
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,1,4,2,1,4,2,1};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        Solution3 s = new Solution3();
        System.out.println(s.removeElements(head,1));
    }
}