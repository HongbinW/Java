package LeetCode.classify.array;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/15
 */
public class LeetCode106_buildTree_从中序与后序遍历序列构造二叉树 {
    int preIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++){
            map.put(inorder[i],i);
        }
        preIndex = postorder.length;
        return process(postorder,inorder,0,inorder.length-1,map);
    }

    public TreeNode process(int[] preorder, int[] inorder, int inLeft, int inRight, HashMap<Integer,Integer> map){
        if (preIndex == -1 || inLeft < 0 || inRight >= inorder.length || inLeft > inRight){
            return null;
        }
        preIndex --;
        Integer j = map.get(preorder[preIndex]);
        if (j == null){
            preIndex ++;
            return null;
        }
        TreeNode node = new TreeNode(inorder[j]);
        node.left = process(preorder,inorder,inLeft,j-1,map);
        node.right = process(preorder,inorder,j+1,inRight,map);
        return node;
    }
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        LeetCode106_buildTree_从中序与后序遍历序列构造二叉树 test = new LeetCode106_buildTree_从中序与后序遍历序列构造二叉树();
        test.buildTree(preorder,inorder);
    }
}
