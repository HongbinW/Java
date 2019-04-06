/**
 * @Author: HongbinW
 * @Date: 2019/4/6 13:30
 * @Version 1.0
 * @Description:
 */
public class Solution {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node node = null;
        Node node1 = new Node(2);
        node.next = node1;
        node1.next = null;
        if(node == null){
            System.out.println("node is null");
        }else
            System.out.println(node.value + " " + node.next.value);

    }
}
