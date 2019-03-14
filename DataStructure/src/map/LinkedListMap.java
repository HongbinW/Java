package map;
import linkedlist.LinkedList;
import set.FileOperation;
import set.LinkedListSet;

import java.util.ArrayList;

public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){
            this(key,null,null);
        }
        public Node(){this(null,null,null);}

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    private Node getNode(K key){
        Node node = dummyHead.next;
        while(node != null){
            if(node.key.equals(key)){
                return node;
            }else{
                node = node.next;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key){
        if(getNode(key) != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public V get(K key){
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key,V value){
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size ++;
        }else{
            node.value = value;
        }
    }

    @Override
    public void set(K key,V newValue){
        Node node = getNode(key);
        if(node == null){
            throw new RuntimeException(key + " doesn't exist!");
        }else{
            node.value = newValue;
        }
    }

    @Override
    public V remove(K key){
        Node node = dummyHead;
        while(node.next != null){
            if(node.next.key.equals(key)){
                Node delNode = node.next;
                node.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.value;
            }
            node = node.next;
        }
        return null;
    }
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:\\睿思\\王洪斌\\玩转数据结构 从入门到进阶（15章全）\\Play-with-Data-Structures-master\\07-Set-and-Map\\03-Time-Complexity-of-Set\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListMap<String,Integer> map = new LinkedListMap<>();
            for (String word : words1) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                }else{
                    map.add(word,1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();

    }
}
