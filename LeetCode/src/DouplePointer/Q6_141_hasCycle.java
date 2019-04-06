package DouplePointer;

/**
 * @Author: HongbinW
 * @Date: 2019/4/4 16:14
 * @Version 1.0
 * @Description:
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Q6_141_hasCycle {
    //超出时间限制
    public boolean hasCycle(ListNode head) {
        ListNode end = head;
        while(end.next != null)     //找不到尾部！！！！
            end = end.next;
        while(head == end){
            if(end.next == head)
                return false;
            head = head.next;
        }
        return true;
    }
    //双指针，如果是个环，则快指针一定会追上慢指针
    public boolean hasCycle2(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && slow != null && fast.next != null){   //最后一个判断为了防止空指针异常
            if(fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
