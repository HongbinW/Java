package linkedlist;

import stack.ArrayStack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedlist = new LinkedList<>();
        for(int i = 0; i < 5 ; i++){
            linkedlist.addFirst(i);
            System.out.println(linkedlist);
        }
        linkedlist.add(666,2);
        System.out.println(linkedlist);

        linkedlist.remove(2);
        System.out.println(linkedlist);

        linkedlist.removeFirst();
        System.out.println(linkedlist);

        linkedlist.removeLast();
        System.out.println(linkedlist);

        System.out.println(linkedlist.get(2));
        linkedlist.removeElement(1);
        System.out.println(linkedlist);
    }
}

