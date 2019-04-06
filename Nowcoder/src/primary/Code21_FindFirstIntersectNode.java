package primary;

/**
 * @Author: HongbinW
 * @Date: 2019/4/6 16:58
 * @Version 1.0
 * @Description: 两个单链表相交的一系列问题  ***有点难***
 * 3.14
 */
public class Code21_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null)
            return null;
        Node fast = head.next.next;
        Node slow = head.next;
        while(fast != slow){
            if(fast.next == null || fast.next.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static Node noLoop(Node head1, Node head2){
        if(head1 == null || head2 == null)
            return null;
        int count = 0;      //两个链表的长度差值
        Node cur1 = head1;
        Node cur2 = head2;
        while(cur1.next != null){
            count++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            count--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        cur1 = count > 0 ? head1 : head2;       //值得学习一下，省去了众多比较
        cur2 = cur1 == head1 ? head2 : head1;   //让cur1指向较长的链表,cur2指向较短的链表
        count = Math.abs(count);
        while(count != 0){      //让长链表先走count步
            count--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while(n != 0){
                cur1 = cur1.next;
                n--;
            }
            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        else{
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;   //或者loop2也行
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
