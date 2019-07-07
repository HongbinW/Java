package LeetCode.Hot100;

/**
 * @Author: HongbinW
 * @Date: 2019/6/22 20:52
 * @Version 1.0
 * @Description:
 */
public class LeetCode437_pathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return process(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    public int process(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        int count = 0;
        int curSum = sum - root.val;
        if(curSum == 0){
            count = 1;      //不能直接返回，因为可能下面和为0
        }
        return process(root.left,curSum) + process(root.right,curSum) + count;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(new LeetCode437_pathSum().pathSum(root,8));
    }
}
