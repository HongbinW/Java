package primary.primary4_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/4/21 21:22
 * @Version 1.0
 * @Description:
 */
public class Code05_IsBSTAndCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    //待测试
    public static boolean isBSTDG(Node head){
        if(head == null){
            return true;
        }
        boolean b1 = isBSTDG(head.left);
        if(!b1)
            return false;
        boolean b2 = isBSTDG(head.right);
        if(!b2)
            return false;
        boolean b = head.left == null ? true : head.left.value < head.value;
        if(!b)
            return false;
        b = head.right == null ? true : head.value < head.right.value;
        return b;
    }
    //待测试
    public static boolean isBST(Node head){
        if(head == null)
            return true;
        int pre = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || head != null){
            if(head.left != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                if(pre >= head.value)
                    return false;
                if(head.right != null){
                    head = head.right;
                    stack.push(head);
                }
            }
        }
        return true;
    }

    public static boolean isCBT(Node head){
        if(head == null)
            return true;
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            // 后半段左孩子为空，右孩子不为空，前半段，开启也阶段的阶段，若左右孩子有不为空的，则为false
            if((leaf && (l != null || r != null)) || (l == null && r != null)){
                return false;
            }
            //目前剩下三种情况，左右都为空，左不空右空，左右都不空
            if(l != null){
                queue.offer(l);
            }
            if(r != null){
                queue.offer(r);
            }else{      //只要右为空，则从该节点开始，之后的节点就必须为孩子节点了
                leaf = true;
            }
        }
        return true;
    }
}
