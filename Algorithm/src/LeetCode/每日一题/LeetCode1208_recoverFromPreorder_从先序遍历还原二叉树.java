package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/18
 */
public class LeetCode1208_recoverFromPreorder_从先序遍历还原二叉树 {
    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        TreeNode res = new LeetCode1208_recoverFromPreorder_从先序遍历还原二叉树().recoverFromPreorder(s);
        System.out.println();
    }
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode recoverFromPreorder(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        return process(S.toCharArray(),0);
    }
    int start = 0;
    public TreeNode process(char[]chs, int depth){
        if (start == chs.length){
            return null;
        }
        int count = 0;
        while (start < chs.length && chs[start] == '-'){
            count ++;
            start ++;
        }
        if (start == chs.length || count != depth){ // 如果不是该深度的，则回滚start
            start -= count;
            return null;
        }
        int num = chs[start++] - '0';
        while (start < chs.length && chs[start] != '-'){
            num = num * 10 + chs[start++] - '0';
        }
        TreeNode node = new TreeNode(num);
        node.left = process(chs,depth+1);
        node.right = process(chs, depth+1);
        return node;
    }
}
