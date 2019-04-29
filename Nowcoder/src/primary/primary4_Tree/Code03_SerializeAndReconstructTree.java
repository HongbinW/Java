package primary.primary4_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/4/21 16:07
 * @Version 1.0
 * @Description:
 */
public class Code03_SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serialByPre(Node head) {
        if(head == null)
            return "#_";
        String str = "";
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node != null) {
                str = str + node.value + "_";
                stack.push(node.right);
                stack.push(node.left);
            }
            else
                str += "#_";
        }
        return str;
    }

    public static String serialByPreDG(Node head){
        if(head == null)
            return "#_";
        String str = head.value + "_";
        str += serialByPreDG(head.left);
        str += serialByPreDG(head.right);
        return str;
    }

    //反序列化
    public static Node deSerialByPre(String str){
        String[] s = str.split("_");                    //借助队列依次弹出，避免了递归时左右子树之间切换时，数组索引难以判断
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < s.length; i++){
            queue.offer(s[i]);
        }
        return deSerialByPre(queue);
    }
    private static Node deSerialByPre(Queue<String> queue){
        if(queue.poll().equals("#_"))
            return null;
        Node node = new Node(Integer.valueOf(queue.poll()));
        node.left = deSerialByPre(queue);
        node.right = deSerialByPre(queue);
        return node;
    }

    //按层序列化
    public static String serialByLevel(Node head){
        if(head == null)
            return "#_";
        String str = head.value + "_";
        Queue<Node> queue = new LinkedList<>(); //因为是层序遍历，每一层都要从左往右，即既要从左往右录入节点，又要从左往右录入字符串中，所以要用队列
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            if(head.left != null){
                queue.offer(head.left);
                str += head.left.value + "_";
            }else{
                str += "#_";
            }
            if(head.right != null){
                queue.offer(head.right);
                str += head.right.value + "_";
            }else{
                str += "#_";
            }
        }
        return str;
    }

    public static Node deSerialByLevel(String str){
        String[] s = str.split("_");
        Node head = curNode(s[0]);
        int i = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = curNode(s[i++]);
            node.right = curNode(s[i++]);
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return head;
    }
    private static Node curNode(String str){
        if(str.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(str));
    }
}
