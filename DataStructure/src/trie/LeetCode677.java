package trie;

import java.util.TreeMap;

/**
 * @Author: HongbinW
 * @Date: 2019/3/19 22:42
 * @Version 1.0
 * @Description: 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 */
public class LeetCode677 {
    private class Node{
        int value;
        TreeMap<Character,Node> next;
        public Node(){
            this(0);
        }
        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }
    }
    private Node root;
    public LeetCode677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if (!cur.next.containsKey(c))
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.next.containsKey(c)){
                return 0;
            }
            cur = cur.next.get(c);
        }

//        return cur.value+sumAll(cur);
        return sumAll(cur);
    }
    private int sumAll(Node node){
//        if(node == null)
//            return 0;
//        int sum = 0;
//        for(char nextChar : node.next.keySet()){
//            sum += node.next.get(nextChar).value;
//            sum += sumAll(node.next.get(nextChar));
//        }
//        return sum;
        int res = node.value;
        for(char c : node.next.keySet())
            res += sumAll(node.next.get(c));
        return res;
    }

    public static void main(String[] args) {
        LeetCode677 tset = new LeetCode677();
        tset.insert("apple",3);
        System.out.println(tset.sum("apple"));
        tset.insert("apple",3);
    }
}
