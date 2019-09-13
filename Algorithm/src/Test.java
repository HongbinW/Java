import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.UUID;
import java.util.concurrent.*;

public class Test{
    static class Node{
        int val;
        Node left,right;
        public Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        traverse(root);
    }
    public static void traverse(Node root){
        if(root == null){
            return;
        }
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }
}