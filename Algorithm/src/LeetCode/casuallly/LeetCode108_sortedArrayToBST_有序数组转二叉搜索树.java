package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/15
 */
public class LeetCode108_sortedArrayToBST_有序数组转二叉搜索树 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return process(nums,0,nums.length - 1);
    }
    public TreeNode process(int[] arr, int left, int right){
        if (left > right){
            return null;
        } else if (left == right){
            return new TreeNode(arr[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = process(arr,left,mid-1);
        root.right = process(arr,mid+1,right);
        return root;
    }
}
