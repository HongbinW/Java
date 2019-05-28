package JZOffer.G_simplifyQ;

import java.util.HashMap;

public class M35_ComplexListCopy {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode node1 = new RandomListNode(node.label);
            map.put(node,node1);
        }
        node = pHead;
        while(node != null){
            RandomListNode temp = map.get(node);
            temp.next = map.get(node.next);
            temp.random = map.get(node.random);
        }
        return map.get(pHead);
    }

    //不用额外的数据结构
    public static RandomListNode CloneWithNoStructure(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        RandomListNode node = pHead;
        RandomListNode pNext = pHead.next;
        do{
            RandomListNode temp = new RandomListNode(node.label);
            node.next = temp;
            temp.next = pNext;
            node = pNext;
            pNext = pNext != null ? pNext.next : null;
        }while (node != null);
        node = pHead;
        while(node != null){
            pNext = node.next;
            pNext.random = node.random != null ? node.random.next : null;
            node = node.next.next;
        }
        //断开
        node = pHead;
        pNext = node.next;
        RandomListNode temp = pNext;
        while (node != null){
            node.next = temp.next;
            node = node.next;
            temp.next = node != null ? node.next : null;
            temp = temp.next;
        }
        return pNext;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        node.next = new RandomListNode(2);
        node.next.next = new RandomListNode(3);
        node.next.next.next = new RandomListNode(4);
        node.next.next.next.next = new RandomListNode(5);
        node.random = node.next.next;
        node.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next;
        CloneWithNoStructure(node);
    }
}
