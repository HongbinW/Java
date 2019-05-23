package LeetCode.tencent_50Questions;

import java.util.Stack;

public class LeetCode230_kthSmallest {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    //中序遍历
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                k--;
                if(k == 0){
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    //法二：
    public int kthSmallest(TreeNode root, int k) {
        midOrder(root,k);
        return res;
    }
    private int i=1;
    private int res;
    private void midOrder(TreeNode root,int k){
        if (root==null)
            return;
        midOrder(root.left,k);
        if(i>k)
            return ;//相当于设置了一个返回的标记，表示已经找到第k小的值了，不用继续向下寻找了。
        if(i++==k){
            res=root.val;
            return;
        }
        midOrder(root.right,k);
    }
}
