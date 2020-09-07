package LeetCode.casuallly;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/5
 */
public class LeetCode460_LFU {

}

class LFUCache {
    class Node{
        int key;
        int val;
        int count = 1;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        void addCount(){
            this.count ++;
        }
    }

    HashMap<Integer,Node> data;     //key-value
    HashMap<Integer,LinkedList<Node>> countMap;     // 次数-该次数的所有key-value
    int minCount;
    int capacity;
    int size;

    public LFUCache(int capacity) {
        data = new HashMap<>();
        countMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!data.containsKey(key)){
            return -1;
        }else{
            Node node = data.get(key);
            updateCount(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (data.containsKey(key)){
            Node node = data.get(key);
            node.val = value;
            updateCount(node);
        }else{
            if (size == capacity){
                if (countMap.get(1).size() > 1){
                    countMap.get(1).removeLast();
                }else{
                    countMap.get(minCount).removeLast();
                }
            }
            Node node = new Node(key,value);
            if (minCount != 1){
                minCount = 1;
            }
            size ++;
            if (countMap.containsKey(1)){
                countMap.get(1).addFirst(node);
            }else{
                LinkedList<Node> list = new LinkedList<>();
                list.addFirst(node);
                countMap.put(node.count,list);
            }
        }
    }

    public void updateCount(Node node){
        countMap.get(node.count).remove(node);
        if (countMap.get(node.count).isEmpty()){
            minCount ++;
        }
        node.addCount();
        if (countMap.containsKey(node.count)){
            countMap.get(node.count).addFirst(node);
        }else{
            LinkedList<Node> list = new LinkedList<>();
            list.addFirst(node);
            countMap.put(node.count,list);
        }
    }
}

class LFUCache2 {
    class Node {
        int key;
        int value;
        int freq = 1;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache2(int capacity) {
        cache = new HashMap<> (capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}
