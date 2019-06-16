package JZOffer.J_knowledgeTransfer;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class M54_KthNode {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        //非递归中序遍历
        return inOrder(pRoot,k);
    }

    public TreeNode inOrder(TreeNode pRoot, int k){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        pRoot = pRoot.left;
        int count = 0;
        while (!stack.isEmpty() || pRoot != null){
            if (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }else{
                pRoot = stack.pop();
                count ++;
                if(count == k){
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(new M54_KthNode().KthNode(root,6).val);
    }
}
