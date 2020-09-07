package LeetCode.classify.array;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/15
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class LeetCode105_buildTree_从前序和中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++){
            map.put(inorder[i],i);
        }
        return process(preorder,inorder,0,preorder.length-1,map);
    }
    int preIndex = -1;
    public TreeNode process(int[] preorder, int[] inorder, int inLeft, int inRight, HashMap<Integer,Integer> map){
        if (preIndex == preorder.length || inLeft < 0 || inRight >= inorder.length || inLeft > inRight){
            return null;
        }
        preIndex ++;
        Integer j = map.get(preorder[preIndex]);
        if (j == null){
            preIndex --;
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
        LeetCode105_buildTree_从前序和中序遍历序列构造二叉树 test = new LeetCode105_buildTree_从前序和中序遍历序列构造二叉树();
        test.buildTree(preorder,inorder);
    }
}
