package map;

import set.FileOperation;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value, Node left, Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value){
            this(key,value,null,null);
        }
        public Node(){this(null,null,null,null);}

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
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

    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) == 0){
            return node;
        }
        else if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }
        else{
            return getNode(node.right,key);
        }
    }

    @Override
    public boolean contains(K key){
        return getNode(root,key) != null;
    }

    @Override
    public void add(K key,V value){
        root = add(key,value,root);
    }
    private Node add(K key,V value,Node node){
        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(key, value,node.left);
        else if(key.compareTo(node.key) > 0)
            node.right = add(key, value,node.right);
        else // key.compareTo(node.key) == 0
            node.value = value;

        return node;
    }

    @Override
    public void set(K key, V value){
        Node node = getNode(root,key);
        if(node == null){
            throw new RuntimeException(key + " doesn't exist!");
        }else{
            node.value = value;
        }
    }

    @Override
    public V get(K key){
        Node node = getNode(root,key);
        return node == null ? null : node.value;
    }

    @Override
    public V remove(K key){
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }
    private Node remove(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) == 0){
            Node newNode = minimum(node.right);
            if(newNode == null){
                newNode = node.left;            //若右子树为空，则直接绑定到左子树返回即可
                size --;
                node.left = null;
                return newNode;
            }
            newNode.right = removeMin(node.right);      //为什么必须要先右再左？？？？
            newNode.left = node.left;
            node = null;
            return newNode;
        }
        else if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
        }else{
            node.right = remove(node.right,key);
        }
        return node;
    }

    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return  minimum(node.left);
    }

    //删除掉以node为根的二分搜索树中的最小的节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:\\睿思\\王洪斌\\玩转数据结构 从入门到进阶（15章全）\\Play-with-Data-Structures-master\\07-Set-and-Map\\03-Time-Complexity-of-Set\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTMap<String,Integer> map = new BSTMap<>();
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
