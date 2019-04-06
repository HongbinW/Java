package primary;

import java.util.ArrayList;

/**
 * @Author: HongbinW
 * @Date: 2019/4/3 17:55
 * @Version 1.0
 * @Description: 将单向链表按某值划分为左边小、中间相等、右边大的形式
 * Nowcoder 3_12
 */
public class Code19_SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    //链表--->数组--->荷兰国旗
    public static Node listPartition1(Node head, int pivot) {
        ArrayList<Integer> list = new ArrayList<>();
        Node node = head;
        while(node != null){
            list.add(node.value);
            node = node.next;
        }
        int size = list.size();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = list.get(i);
        }
        int less = -1;
        int more = arr.length;
        int i = 0;
        while (i<more){
            if(arr[i] < pivot)
                swap(arr,++less,i++);
            else if(arr[i] > pivot)
                swap(arr,i,--more);
            else
                i++;
        }
        node = head;
        for(int j = 0; j < arr.length; j++){
            node.value = arr[j];
            node = node.next;
        }
        return head;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //思路二：转化为三个小链表，再连接
    public static Node listPartition2(Node head, int pivot) {
        Node less = null;
        Node equal = null;
        Node more = null;
        Node lessl = null;
        Node equall = null;
        Node morel = null;
        Node next = null;

        while(head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot) {
                if (less == null) {
                    less = head;
                    lessl = head;
                }
                else {
                    lessl.next = head;
                    lessl = lessl.next;
                }
            }
            else if(head.value == pivot) {
                if (equal == null) {
                    equal = head;
                    equall = head;
                }
                else {
                    equall.next = head;
                    equall = equall.next;
                }
            }
            else {
                if (more == null) {
                    more = head;
                    morel = head;
                }
                else {
                    morel.next = head;
                    morel = morel.next;
                }
            }
            head = next;
        }
        //less and equal connection
        if(less != null) {
            head = less;
            lessl.next = equal;
            equall = equall == null ? lessl : equall;
            equall.next = more;
        }
        //all connection
        else if(equall != null){
            head = equal;
            equall.next = more;
        }
        else
            head = more;
        return head;
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(7);
        head1.next.next.next.next = new Node(8);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(3);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}
