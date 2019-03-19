package trie;

import java.util.TreeMap;

/**
 * @Author: HongbinW
 * @Date: 2019/3/19 22:12
 * @Version 1.0
 * @Description: 设计一个支持一下两个操作的数据结构
 *                  void addWord(word)
 *                  bool search(word)
 *                  search(word)可以搜索文字或正则表达式字符串，字符串只包含.或a-z，其中.意味着可以代表任何一个字母
 */
public class LeetCode211 {
    private class Node{
    public boolean isWord;
    public TreeMap<Character,Node> next;
    public Node(boolean isWord){
        this.isWord = isWord;
        next = new TreeMap<>();
    }
    public Node(){
        this(false);
    }
    }
    private Node root;
    public LeetCode211() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c))
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root,0,word);
    }
    private boolean match(Node node, int index, String word){
        if(index == word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.') {
            if (node.next.containsKey(c)) {
                return match(node.next.get(c), index + 1, word);
            } else {
                return false;
            }
        }else{
            for(char nextChar:node.next.keySet()){
                if(match(node.next.get(nextChar),index+1,word)){
                    return true;
                }
            }
            return false;
        }
    }
}
