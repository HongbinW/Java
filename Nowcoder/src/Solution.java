/**
 * @Author: HongbinW
 * @Date: 2019/4/6 13:30
 * @Version 1.0
 * @Description:
 */
public class Solution {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        String s = "%Y";
        System.out.println(s.charAt(0) == s.charAt(1));
    }
}
