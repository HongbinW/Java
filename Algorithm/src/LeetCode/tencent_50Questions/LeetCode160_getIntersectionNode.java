package LeetCode.tencent_50Questions;

public class LeetCode160_getIntersectionNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //方法一：
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int countA = 0,countB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA.next != null){
            nodeA = nodeA.next;
            countA ++;
        }
        while(nodeB.next != null){
            nodeB = nodeB.next;
            countB ++;
        }
        if(nodeA != nodeB){
            return null;
        }
        nodeA = headA;
        nodeB = headB;
        if(countA > countB){
            int diff = countA - countB;
            while(diff > 0){
                nodeA = nodeA.next;
                diff --;
            }
        }else{
            int diff = countB - countA;
            while(diff > 0){
                nodeB = nodeB.next;
                diff --;
            }
        }
        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    //方法二：
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(8);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(5);
        headA.next.next = new ListNode(6);
        System.out.println(getIntersectionNode2(node,headA) == null ? null : 1);

    }
}
