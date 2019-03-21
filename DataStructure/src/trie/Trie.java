package trie;

import java.util.TreeMap;

/**
 * @Author: HongbinW
 * @Date: 2019/3/19 20:44
 * @Version 1.0
 * @Description: 字典树、前缀树，主要用于字符串处理
 *  局限性：空间！
 *  扩展：压缩搜索树，节省空间，维护麻烦
 *        三分搜索树，节省空间，牺牲时间
 *        后缀树
 */

public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;    //相当于下一个字符在连接线上，即知道了下一个节点的字符，然后才去了下一个节点
        public Node(boolean isWord){            //且此处字符的映射是一个节点，即get(c)就是该字符所在的节点
            this.isWord = isWord;               //next是当前节点的
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }
    //获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //向Trie中添加单词word
    public void add(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c))
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord) {       //如果该单词之前存在了，就不需要下面的操作
            cur.isWord = true;
            size++;
        }
    }

    public void add_DG(String word){
        add_DG(word,0,root);
    }

    private void add_DG(String word, int i, Node node){
        if(i == word.length()){     //注意i的取值,应该是他比较完最后一个，即length-1后才能结束，所以是i==word.length()
            if(!node.isWord){
                node.isWord = true;
                size ++;
            }
            return;
        }
        if(node.next.containsKey(word.charAt(i))){
            add_DG(word,i+1,node.next.get(word.charAt(i)));
        }else{
            Node cur = new Node();
            node.next.put(word.charAt(i),cur);
            add_DG(word,i+1,cur);
        }
    }
    //查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.next.containsKey(c)){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    //前缀搜索
    public boolean isPrefix(String prefix){
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.next.containsKey(c)){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }


}
