package Zuo100.c5;

/**
 * Description
 * Author  HongbinW
 * Date 2019/10/27
 */
public class Q3_entryCircleNode_第一个相交节点 {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public Node firstNode(Node node1, Node node2){
        if (node1 == null || node2 == null){
            return null;
        }
        Node loop1 = firstEntryCircleNode(node1);
        Node loop2 = firstEntryCircleNode(node2);
        if (loop1 == null && loop2 == null){
            return withoutLoop(node1,node2,null);
        }else if(loop1 != null && loop2 != null){
            return withLoop(node1,node2,loop1,loop2);
        }else {
            return null;
        }
    }

    public Node firstEntryCircleNode(Node node){
        if (node == null || node.next == null){
            return null;
        }
        Node slow = node.next;
        Node fast = node.next.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = node;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public Node withoutLoop(Node node1, Node node2, Node end){
        int len1 = 0, len2 = 0;
        Node p1 = node1;
        Node p2 = node2;
        while (p1 != end){
            len1 ++;
            p1 = p1.next;
        }
        while (p2 != end){
            len2 ++;
            p2 = p2.next;
        }
        if (p1 != p2){
            return null;
        }
        if (len1 > len2){
            int diff = len1 - len2;
            while (diff > 0){
                node1 = node1.next;
                diff --;
            }
        }else {
            int diff = len2 - len1;
            while (diff > 0){
                node2 = node2.next;
                diff --;
            }
        }
        while (node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public Node withLoop(Node node1, Node node2, Node loop1, Node loop2){
        if (loop1 == loop2){
            return withoutLoop(node1,node2,loop1);
        }else{
            Node p = loop1.next;
            while (p != loop2){
                if (p == loop1){
                    return null;
                }
                p = p.next;
            }
            return loop1;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node head2 = new Node(7);
        head2.next= new Node(6);
        head2.next.next = new Node(5);
        Node res = new Node(4);
        res.next = new Node(-4);
        res.next.next = new Node(-5);
        res.next.next.next = new Node(-6);
        res.next.next.next.next = res;
        head1.next.next.next = res;
        head2.next.next.next = res;
        System.out.println(new Q3_entryCircleNode_第一个相交节点().firstNode(head1,head2).value);
    }
}
