import java.util.ArrayList;

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
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        for(int i = 0 ; i < 3; i++){
            list1.add(i);
            list2.add(i);
        }
        ArrayList<ArrayList> list = new ArrayList<>();
        list.add(list1);
        System.out.println(list.contains(list2));
        System.out.println(list1);
        System.out.println(list2);
    }
}