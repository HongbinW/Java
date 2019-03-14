package set;
import linkedlist.LinkedList;

import java.util.ArrayList;

public class LinkedListSet<E> implements Set<E> {       //线性表不具有比较性
    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void add(E e){
        if(list.contains(e)) {
            return;
        }else{
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e){
        list.removeElement(e);
    }
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:\\睿思\\王洪斌\\玩转数据结构 从入门到进阶（15章全）\\Play-with-Data-Structures-master\\07-Set-and-Map\\03-Time-Complexity-of-Set\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

    }
}
