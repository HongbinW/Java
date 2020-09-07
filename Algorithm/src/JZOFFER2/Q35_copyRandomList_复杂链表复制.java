package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Q35_copyRandomList_复杂链表复制 {
    public static void main(String[] args) {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        node1.random = node0;
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        copyRandomList(node0);
    }
    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;

        while (cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            Node tmp = cur.next;
            if (cur.random != null)
                tmp.random = cur.random.next;
            cur = cur.next.next;
        }
        Node newHead = head.next;
        cur = newHead;
        while(head != null){
            head.next = cur.next;
            head = head.next;
            if (head != null)
                cur.next = head.next;
            else
                cur.next = null;
            cur = cur.next;
        }
        return newHead;
    }
}
