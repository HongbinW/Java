package LeetCode.每日一题;

import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/16
 */
public class LeetCode297_serialize_tree_二叉树的序列化和反序列化 {
    class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.left != null){
                queue.add(root.left);
                sb.append(",");
                sb.append(root.left.val);
            }else{
                sb.append(",null");
            }
            if (root.right != null){
                queue.add(root.right);
                sb.append(",");
                sb.append(root.right.val);
            }else{
                sb.append(",null");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] strs = data.split(",");
        //recur
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        queue.add(root);
        for (int i = 1; i < strs.length;){
            TreeNode node = queue.poll();
            if (!strs[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(strs[i++]));
                queue.add(node.left);
            }else{
                i ++;
            }
            if (i < strs.length && !strs[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(strs[i++]));
                queue.add(node.right);
            }else {
                i ++;
            }
        }
        return root;
    }
}
