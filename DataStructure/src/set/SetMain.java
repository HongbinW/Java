package set;

import java.util.ArrayList;

public class SetMain {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> word1 = new ArrayList<>();
        if(FileOperation.readFile("E:\\睿思\\王洪斌\\玩转数据结构 从入门到进阶（15章全）" +
                "\\Play-with-Data-Structures-master\\07-Set-and-Map\\01-Set-Basics-and-BSTSet" +
                "\\pride-and-prejudice.txt",word1)) {
            System.out.println("Total words: " + word1.size());
            BSTSet<String> set1 = new BSTSet<>();
            for (String word : word1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }
    }
}
