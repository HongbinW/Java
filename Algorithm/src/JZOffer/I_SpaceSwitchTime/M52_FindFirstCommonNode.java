package JZOffer.I_SpaceSwitchTime;

import java.util.List;

public class M52_FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode pEnter1 = findEnterNode(pHead1);
        ListNode pEnter2 = findEnterNode(pHead2);
        //两个链表均无环
        if(pEnter1 == null && pEnter2 == null){
            return withoutCircle(pHead1,pHead2);
        }
        //一个链表有环，另一个链表无环
        else if(pEnter1 == null && pEnter2 != null || pEnter1 != null && pEnter2 == null){
            return null;
        }
        //两个链表均有环
        else{
            return withCircle(pHead1,pHead2,pEnter1,pEnter2);
        }
    }

    //查找入环第一个节点
    public ListNode findEnterNode(ListNode pHead){
        if (pHead.next == null || pHead.next.next == null){
            return null;
        }
        ListNode pNode1 = pHead.next;
        ListNode pNode2 = pHead.next.next;
        while (pNode2 != null && pNode2.next != null && pNode2.next.next != null){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next.next;
            if (pNode1 == pNode2){
                pNode1 = pHead;
                while (pNode1 != pNode2){
                    pNode1 = pNode1.next;
                    pNode2 = pNode2.next;
                }
                return pNode1;
            }
        }
        return null;
    }

    public ListNode withoutCircle(ListNode pHead1, ListNode pHead2){
        int size1 = 1, size2 = 1;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null){
            p1 = p1.next;
            size1 ++;
        }
        while (p2 != null){
            p2 = p2.next;
            size2 ++;
        }
        if (p1 != p2){
            return null;
        }
        int diff = 0;
        p1 = pHead1;
        p2 = pHead2;
        if(size1 > size2){
            diff = size1 - size2;
            while(diff > 0){
                p1 = p1.next;
                diff --;
            }
        }else{
            diff = size2 - size1;
            while (diff > 0){
                p2 = p2.next;
                diff--;
            }
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode withCircle(ListNode pHead1, ListNode pHead2, ListNode pEnter1, ListNode pEnter2){
        ListNode p1 = pEnter1;
        if (pEnter1 == pEnter2){
            int size1 = 1,size2 = 1;
            p1 = pHead1;
            ListNode p2 = pHead2;
            while (p1 != pEnter1){
                size1 ++;
                p1 = p1.next;
            }
            while (p2 != pEnter1){
                size2 ++;
                p2 = p2.next;
            }
            int diff = 0;
            if (size1 > size2){
                diff = size1 - size2;
                while (diff > 0){
                    pHead1 = pHead1.next;
                    diff --;
                }
            }else{
                diff = size2 - size1;
                while (diff > 0){
                    pHead2 = pHead2.next;
                    diff --;
                }
            }
            while (pHead1 != pHead2){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }else{
            while (p1 != pEnter1){
                if(p1 == pEnter2){
                    return pEnter1;
                }
                p1 = p1.next;
            }
        }
        return null;
    }
}
