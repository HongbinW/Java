package LeetCode.会员.华为;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/27
 */
public class LeetCode820_minimumLengthEncoding_单词的压缩编码 {
    class Node{
        int value;
        Node[] nodes = new Node[26];
        Node(int value){
            this.value = value;
        }
    }

    //字段树
    public static void main(String[] args) {
        System.out.println(new LeetCode820_minimumLengthEncoding_单词的压缩编码().minimumLengthEncoding(new String[]{"time", "atime", "btime"}));
    }
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Node ori = new Node(0);
        for (int i = 0; i < words.length; i ++){
            char[] chs = words[i].toCharArray();
            Node root = ori;
            for (int j = chs.length-1; j >= 0; j --){
                if (root.nodes[chs[j]-'a'] != null){
                    if (j != 0) {   //如果刚好也走到头，即有重复的字符串，那就不算了。否则就把原来的减掉，并将value置为0
                        res -= root.nodes[chs[j] - 'a'].value;
                        root.nodes[chs[j] - 'a'].value = 0;
                    }
                    root = root.nodes[chs[j]-'a'];
                }else{
                    if (j == 0){        //在最后结尾的位置给设置为字符串长度
                        root.nodes[chs[j] - 'a'] = new Node(chs.length+1);
                    }else {
                        root.nodes[chs[j] - 'a'] = new Node(0);
                    }
                    res += root.nodes[chs[j] - 'a'].value;
                    root = root.nodes[chs[j]-'a'];
                }
            }
        }
        return res;
    }
//    public int process(Node root, char[] chs){
//        boolean flag = false;
//        for (int i = chs.length - 1; i >= 0; i --){
//            if (root.nodes[chs[i]-'a'] != null){
//                root = root.nodes[chs[i]-'a'];
//            }else{
//                flag = true;
//                root.nodes[chs[i]-'a'] = new Node();
//                root = root.nodes[chs[i]-'a'];
//            }
//        }
//        return flag ? chs.length + 1 : 0;
//    }
}
