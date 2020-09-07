package LeetCode.会员.猿辅导;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */

public class LeetCode314_verticalOrder_二叉树垂直遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(2);
        root.right.left.left = new TreeNode(5);
        new LeetCode314_verticalOrder_二叉树垂直遍历().verticalOrder(root);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // AC 100%
    // 整体思路，将所有的linkedlist通过left,right指针给连起来，然后维护一个map来维护TreeNode和linkedlist的对应关系
    // queue层序遍历节点，将当前节点的值放到cur(linkedlist),left的放到cur.left,right的放到cur.right
    class NodeList{
        LinkedList<Integer> cur;
        NodeList left;
        NodeList right;
        NodeList(LinkedList<Integer> cur){
            this.cur = cur;
        }
    }
    NodeList head;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode,NodeList> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(root.val);
        NodeList nodeList = new NodeList(list);
        head = nodeList;
        map.put(root,nodeList);
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            nodeList = map.get(root);
            if (root.left != null){
                if (nodeList.left != null) {
                    nodeList.left.cur.add(root.left.val);
                    map.put(root.left, nodeList.left);
                }else {
                    LinkedList<Integer> tmpList = new LinkedList<>();
                    tmpList.add(root.left.val);
                    NodeList tmp = new NodeList(tmpList);
                    tmp.right = nodeList;
                    nodeList.left = tmp;
                    head = tmp;
                    map.put(root.left,tmp);
                }
                queue.add(root.left);
            }
            if (root.right != null){
                if (nodeList.right != null) {
                    nodeList.right.cur.add(root.right.val);
                    map.put(root.right, nodeList.right);
                }else {
                    LinkedList<Integer> tmpList = new LinkedList<>();
                    tmpList.add(root.right.val);
                    NodeList tmp = new NodeList(tmpList);
                    tmp.left = nodeList;
                    nodeList.right = tmp;
                    map.put(root.right,tmp);
                }
                queue.add(root.right);
            }
        }
        while (head != null){
            LinkedList<Integer> l = head.cur;
            res.add(l);
            head = head.right;
        }
        return res;
    }
}
