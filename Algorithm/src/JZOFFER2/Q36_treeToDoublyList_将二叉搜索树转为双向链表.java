package JZOFFER2;

import java.util.Stack;

public class Q36_treeToDoublyList_将二叉搜索树转为双向链表 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    // fastest
    Node pre,head;  //pre是前置
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        recur(root);
        // 将头尾连接到一起
        head.left=pre;
        pre.right = head;
        return head;
    }

    // 中序遍历，通过pre来调节
    public void recur(Node cur){
        if(cur==null) return;

        recur(cur.left);

        if(pre==null) head=cur;
        else pre.right = cur;
        cur.left = pre;
        pre=cur;

        recur(cur.right);

    }

    // mySolution
    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root.left = pre;
                pre = root;
                root = root.right;
            }
        }
        Node tail = pre;
        while (pre.left != null) {
            pre.left.right = pre;
            pre = pre.left;
        }
        pre.left = tail;
        tail.right = pre;
        return pre;
    }
}
