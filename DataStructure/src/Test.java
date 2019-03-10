/**
 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
/*
tips:
    正数的补码就是其本身
    负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)

    正数的反码是他原码
    负数的反码是在其原码的基础上, 除了符号位数不变，其余位取反.
 */

import java.util.Stack;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    public ListNode(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
}

class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        return merge(list1,list2);
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode node = null;
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list1 != null && list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            node = list1;
            list1 = list1.next;
        }else {
            node = list2;
            list2 = list2.next;
        }
        node.next = merge(list1,list2);
        return node;
    }
}
public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1= {1,3,5};
        ListNode list1 = new ListNode(nums1);
        int[] nums2= {2,4,6};
        ListNode list2 = new ListNode(nums2);
        s.Merge(list1,list2);
    }
}