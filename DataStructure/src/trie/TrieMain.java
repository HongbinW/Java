package trie;
import set.FileOperation;

import java.util.ArrayList;

/**
 * @Author: HongbinW
 * @Date: 2019/3/19 21:25
 * @Version 1.0
 * @Description:
 */
public class TrieMain {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:\\睿思\\王洪斌\\玩转数据结构 从入门到进阶（15章全）\\Play-with-Data-Structures-master\\07-Set-and-Map\\03-Time-Complexity-of-Set\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            Trie set1 = new Trie();
            for (String word : words1)
                set1.add_DG(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();
    }
}
