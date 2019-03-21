public class Test{
    static class ListNode{
        int value;
        ListNode next;

        public ListNode(){
            this(0);
        }

        public ListNode(int value){
            this.value = value;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
//        node1 = node2;      //此处，node2已将自己的value和next全都给了node1
        node1.next = node2.next;        //此处，只是将node1也连到node3
        System.out.println(node1.next.value);
    }
}