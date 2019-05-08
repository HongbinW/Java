import com.sun.org.apache.regexp.internal.RE;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if(n == 0){
            list.add(0);
            return list;
        }else if(n == 1){
            list.add(0);
            list.add(1);
            return list;
        }else{
            list.add(0b00);
            list.add(0b01);
            list.add(0b11);
            list.add(0b10);
            if(n > 2){

            }

            return list;
        }
    }
}