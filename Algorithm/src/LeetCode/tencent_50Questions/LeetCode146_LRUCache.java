package LeetCode.tencent_50Questions;

import java.util.HashMap;

/**
 * @Author: HongbinW
 * @Date: 2019/9/3 19:29
 * @Version 1.0
 * @Description:
 */
public class LeetCode146_LRUCache {
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, Node> map;
    int capacity;
    int size;
    Node head;
    Node tail;

    public LeetCode146_LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        size = 0;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        removeNode(map.get(key));
        moveToHead(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.get(key).value = value;
            removeNode(map.get(key));
            moveToHead(map.get(key));
        }else{
                Node node = new Node(key,value);
                map.put(key,node);
                moveToHead(node);
                size ++;
            if (size > capacity) {
                int removeKey = tail.pre.key;
                removeNode(tail.pre);
                map.remove(removeKey);
                size--;
            }
        }
    }

    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void moveToHead(Node node){
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public static void main(String[] args) {
        LeetCode146_LRUCache cache = new LeetCode146_LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);
    }
}
