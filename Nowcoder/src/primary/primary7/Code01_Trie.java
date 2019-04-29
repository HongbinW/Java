package primary.primary7;

/**
 * @Author: HongbinW
 * @Date: 2019/4/29 20:38
 * @Version 1.0
 * @Description:
 */
public class Code01_Trie {
    public static class TrieNode{
        public int path;    //多少个字符串经过此节点
        public int end;     //有多少字符串以该节点结尾
        public TrieNode[] nexts;

        public TrieNode(){
            path = 0;
            end = 0;
            nexts = new TrieNode[26];       //感觉可以跟数据结构那块讲的结合一下，使用Map，既有了一定的统计，又不浪费空间
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if(word == null)
                return;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < chs.length; i++){
                int index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node.path++;
                node = node.nexts[index];
            }
            node.end++;
        }
        //查询某个单词插入了几次
        public int search(String str){
            if(str == null)
                return 0;
            char[] chs = str.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < chs.length; i++){
                int index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public void delete(String word){
            if(search(word) != 0){
                char[] chs = word.toCharArray();
                TrieNode node = root;
                for(int i = 0; i < chs.length; i++){
                    int index = chs[i] - 'a';
                    if(--node.nexts[index].path == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end --;
            }
        }
        //以pre为前缀的单词数
        public int prefixNumber(String pre){
            if(pre == null)
                return 0;
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < chs.length; i++){
                int index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }
}
