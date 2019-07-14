package basic;

import java.util.*;
import java.util.function.Consumer;

public class Test1
{
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,9,56,4,5,1,7,5,3,4};
        LinkedList<Integer> list = new LinkedList<>();
        list.push(2);
        list.pop();

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.pop();
    }

}

class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? 1 : -1;
    }
}