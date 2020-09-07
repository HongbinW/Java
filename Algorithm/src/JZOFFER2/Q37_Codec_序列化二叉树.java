package JZOFFER2;

import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
public class Q37_Codec_序列化二叉树 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int x) {
              val = x;
          }
      }

      //序列化为 "[1,2,3,null,null,4,5]"
      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
          if (root == null){
              return "[]";
          }
          StringBuilder sb = new StringBuilder();
          sb.append("[");
          LinkedList<TreeNode> list = new LinkedList<>();
          list.add(root);
          sb.append(root.val);          //关键在于边往队列插节点的时候写结果，而不是等读出结果再写
          sb.append(",");
          while (!list.isEmpty()){
              root = list.poll();
              if (root.left != null){
                  list.add(root.left);
                  sb.append(root.left.val);
                  sb.append(",");
              }else{
                  sb.append("null,");
              }
              if (root.right != null){
                  list.add(root.right);
                  sb.append(root.right.val);
                  sb.append(",");
              }else{
                  sb.append("null,");
              }
          }
          sb.setCharAt(sb.length()-1,']');
          return sb.toString();
      }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.substring(1,data.length()-1).split(",");
        if (strs.length < 3){
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strs[index++]));
        list.add(root);
        while (!list.isEmpty()){
            TreeNode cur = list.poll();
            if (strs[index].equals("null")){
                cur.left = null;
            }else{
                cur.left = new TreeNode(Integer.parseInt(strs[index]));
                list.add(cur.left);
            }
            index ++;
            if (strs[index].equals("null")){
                cur.right = null;
            }else{
                cur.right = new TreeNode(Integer.parseInt(strs[index]));
                list.add(cur.right);
            }
            index ++;
        }
        return root;
    }

    public static void main(String[] args) {
        new Q37_Codec_序列化二叉树().deserialize("[]");
    }
}
