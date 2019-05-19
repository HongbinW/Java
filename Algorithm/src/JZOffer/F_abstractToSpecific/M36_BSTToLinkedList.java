package JZOffer.F_abstractToSpecific;

import java.util.ArrayList;
import java.util.Stack;

public class M36_BSTToLinkedList {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //中序遍历BST，非递归
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRootOfTree);
        ArrayList<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty()){
            if (pRootOfTree != null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }else{
                pRootOfTree = stack.pop();
                list.add(pRootOfTree);
                pRootOfTree = pRootOfTree.right;
            }
        }
        TreeNode head = list.get(0);
        TreeNode node = head;
        for(int i = 1; i < list.size() - 1; i++){
            TreeNode temp = list.get(i);
            node.right = temp;
            temp.left = node;
            node = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(6);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(8);
        node.right = new TreeNode(14);
        node.right.left = new TreeNode(12);
        node.right.right = new TreeNode(16);
        Convert(node);
    }
}
