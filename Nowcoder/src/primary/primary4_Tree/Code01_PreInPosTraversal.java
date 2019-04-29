package primary.primary4_Tree;

import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/4/16 21:14
 * @Version 1.0
 * @Description:
 */
public class Code01_PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    //递归写法
    public static void preOrderRecur(Node head) {
        if(head == null)
            return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public static void inOrderRecur(Node head){
        if(head == null)
            return;
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }
    public static void posOrderRecur(Node head){
        if(head == null)
            return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }
    //非递归写法
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order: ");
        if(head != null){
            Stack<Node> stack = new Stack();
            stack.push(head);
            while(!stack.isEmpty()){
                Node node = stack.pop();
                System.out.print(node.value + " ");
                if(node.right != null)
                    stack.push(node.right);
                if(node.left != null)
                    stack.push(node.left);
            }
        }
        System.out.println();
    }
    public static void inOrderUnRecur(Node head){
        System.out.println("in_order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }
                else{
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
    //先实现中右左，然后全压入另一个栈
    public static void posOrderUnRecur1(Node head){
        System.out.println("pos_order: ");
        if(head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null)
                    stack1.push(head);
                if(head.right != null)
                    stack1.push(head);
            }
            while(!stack2.isEmpty()){
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }
    //只用一个栈
    public static void posOrderUnRecur2(Node head){
        System.out.println("pos_order: ");

    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
//        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);

    }
}
