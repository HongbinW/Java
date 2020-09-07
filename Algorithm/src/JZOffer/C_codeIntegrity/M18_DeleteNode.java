package JZOffer.C_codeIntegrity;


/**
 * @Author: HongbinW
 * @Date: 2019/3/21 11:43
 * @Version 1.0
 * @Description:
 */
class ListNode{
    int value;
    ListNode next;

    public ListNode(){
        this(0);
    }

    public ListNode(int value){
        this.value = value;
        this.next = null;
    }
}
public class M18_DeleteNode {
    //O(1)实现删除链表节点，只需要将要删除元素的下一个元素直接赋给当前元素，然后释放掉下一个元素即可
    //但是对于尾节点还是要从头遍历
    public void DeleteNode(ListNode head,ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        ListNode node = toBeDeleted.next;
        if (node == null) {
            while(head.next!=toBeDeleted){
                head=head.next;
            }
            head.next=null;
        } else if(head == toBeDeleted){
            head = null;
        }
        else {
            toBeDeleted.value = node.value;
            toBeDeleted.next = node.next;
        }
        node = null;
    }
//    public void DeleteNode(ListNode head,ListNode node) {
//        if(node.next==null){
//            while(head.next!=node){
//                head=head.next;
//            }
//            head.next=null;
//        }
//        //要删除的节点是头结点
//        else if(head==node){
//            head=null;
//        }
//        //要删除的节点是中间普通节点
//        else{
//            node.value=node.next.value;
//            node.next=node.next.next;
//        }
//    }

    //Q2
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        ListNode resNode = new ListNode(pHead.value-1);
        resNode.next = pHead;
        ListNode pre = resNode;
        ListNode cur = pHead;
        while(cur != null && cur.next != null){
            if(cur.value == cur.next.value){
                cur = cur.next;
                if(cur.next == null || cur.value != cur.next.value){
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return resNode.next;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(3);

        M18_DeleteNode test = new M18_DeleteNode();
//        test.DeleteNode(node1,node1);
//        System.out.println(node1.value);
////        node1.next = node2;
////        node2.next = node3;
////        test.DeleteNode(node1,node2);
////        System.out.println(node1.next.value);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode node = test.deleteDuplication(node1);
    }
}
