package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/4
 */
public class LeetCode23_mergeKLists_合并k个排序链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // 思路一：堆
    // 思路二：分治
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        while (lists.length > 1){
            ListNode[] newList = new ListNode[(lists.length+1)/2];
            for (int i = 0; i < lists.length; i += 2){
                if (i + 1 < lists.length){
                    newList[i/2] = mergeList(lists[i],lists[i+1]);
                }else{
                    newList[i/2] = lists[i];
                }
            }
            lists = newList;
        }
        return lists[0];
    }
    public ListNode mergeList(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        if (l1.val > l2.val){
            return mergeList(l2,l1);
        }
        ListNode head = l1;
        ListNode cur = head;
        l1 = l1.next;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }else{
            cur.next = l2;
        }
        return head;
    }
}
