package nowcode.LeetCode;

public class copyRandomList_复制有随机指针链表 {
    static class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode cur = head;
        while (cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode node = cur.next;
        newHead.next = node;
        while (cur != null){
            if (node.next == null){
                cur.next = null;
                break;
            }
            cur.next = node.next;
            node.next = node.next.next;
            cur = cur.next;
            node = node.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        new copyRandomList_复制有随机指针链表().copyRandomList(node);
    }
}
