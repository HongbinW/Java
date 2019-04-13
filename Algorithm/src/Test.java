import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
    public void test(int[] test){
        test[1] = 886;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(arr[1]);
    }
}