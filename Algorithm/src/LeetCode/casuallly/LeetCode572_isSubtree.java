package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/9/3 22:10
 * @Version 1.0
 * @Description:
 */
public class LeetCode572_isSubtree {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null){
            return true;
        }
        if (s == null){
            return false;
        }
        if (s.val == t.val){
            if (isValid(s,t)){
                return true;
            }
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    private boolean isValid(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return true;
        }else if (s != null && t != null){
            if (s.val == t.val){
                return isValid(s.left,t.left) && isValid(s.right,t.right);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
