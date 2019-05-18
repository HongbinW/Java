package JZOffer.F_abstractToSpecific;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class M32_PrintTreeFromTopToBottom {
    //Question1
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.right != null){
                queue.offer(node.right);
            }
            if(node.left != null){
                queue.offer(node.left);
            }
            list.add(node.val);
        }
        return list;
    }

    //Question2
    public static void PrintFromTopToBottom2(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curCount = 1;
        int curSumCount = 1;    //可以考虑使用一个变量，表示当前行剩余要打印的个数即可，在打印完毕后，将下一行个数赋值过来即可
        int nextSumCount = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                nextSumCount++;
                queue.offer(node.left);
            }
            if(node.right != null){
                nextSumCount++;
                queue.offer(node.right);
            }
            System.out.print(node.val);
            if(curCount < curSumCount){
                System.out.print(" ");
                curCount++;
            }else if(curCount == curSumCount){
                System.out.println();
                curCount = 1;
                curSumCount = nextSumCount;
                nextSumCount = 0;
            }
        }
    }

    //Question3：“之”字型打印，即一行从左往右，下一行从右往左
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pRoot.val);
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        stack.push(pRoot);
        int restCount = 0;
        int nextCount = 0;
        int row = 1;
        while(!stack.isEmpty() || !temp.isEmpty()){
            TreeNode node = stack.pop();
            //压栈
            if(row % 2 == 0) {
                if (node.right != null) {
                    temp.push(node.right);
                    nextCount++;
                }
                if (node.left != null) {
                    temp.push(node.left);
                    nextCount++;
                }
            }else{
                if (node.left != null) {
                    temp.push(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    temp.push(node.right);
                    nextCount++;
                }
            }
            if(restCount > 0){
                list.add(node.val);
                restCount--;
            }
            if(restCount == 0){
                res.add(list);
                list = new ArrayList<>();
                restCount = nextCount;
                nextCount = 0;
                row++;
                stack = temp;
                temp = new Stack<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(11);
//        PrintFromTopToBottom2(node);
        Print(node);
    }
}
