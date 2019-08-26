import java.util.HashMap;

class LRUCache {
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
    HashMap<Integer,Node> map = new HashMap<>();
    int count;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }

    private void moveToHead(Node node){
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }else{
            remove(node);
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            if (this.count + 1 > this.capacity){
                this.count --;
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            this.count++;
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToHead(newNode);

        }else{

            node.value = value;
            remove(node);
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */