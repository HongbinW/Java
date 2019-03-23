package RedBlackTree;

import set.FileOperation;

import java.util.ArrayList;

/**
 * @Author: HongbinW
 * @Date: 2019/3/22 17:11
 * @Version 1.0
 * @Description:
 */
public class RBTree<K extends Comparable<K> , V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;        //对于新添加的节点，总是要和已有的叶子节点进行融合，所以，默认为红色
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        root = add(root,key,value);
        root.color = BLACK;     //最终根节点为黑色节点
    }
    private Node add(Node node,K key,V value){
        if(node == null){
            Node pNode = new Node(key,value);       //默认红色
            size ++;
            return pNode;
        }
        if(node.key.compareTo(key) > 0){
            node.right = add(node.right,key,value);
        }else if(node.key.compareTo(key) < 0){
            node.left = add(node.left,key,value);
        }else{
            node.value = value;
        }

        //红黑树性质维护
        //判断是否需要左旋转
        if(isRed(node.right) && !isRed(node.left))      //如果左右孩子都是红色，则应进行颜色反转
            node = leftRotate(node);
        //判断是否需要右旋转
        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);
        //是否需要颜色反转
        if(isRed(node.left) && isRed(node.right))
            flipColors(node);
        return node;
    }
    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){ //可能会出现连续两个红色节点的情况
        Node x = node.right;
        Node T2 = x.left;
        node.right = T2;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){
        Node x = node.left;
        Node T1 = x.right;
        node.left = T1;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    //颜色反转
    private void flipColors(Node node){
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }
    private boolean isRed(Node node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }

    public Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        if(node.key.compareTo(key) > 0){
            return getNode(node.right,key);
        }else if(node.key.compareTo(key) < 0){
            return getNode(node.left,key);
        }else{
            return node;
        }
    }

    public boolean contains(K key){
        Node node = getNode(root,key);
        if(node == null){
            return false;
        }else{
            return true;
        }
    }

    public V get(K key){
        Node node = getNode(root,key);
        if(node == null){
            return null;
        }else{
            return node.value;
        }
    }

    public void set(K key,V value){
        Node node = getNode(root,key);
        if(node == null){
            return;
        }else{
            node.value = value;
        }
    }
    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("E:\\睿思\\王洪斌\\玩转数据结构 从入门到进阶（15章全）\\Play-with-Data-Structures-master\\07-Set-and-Map\\03-Time-Complexity-of-Set\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
