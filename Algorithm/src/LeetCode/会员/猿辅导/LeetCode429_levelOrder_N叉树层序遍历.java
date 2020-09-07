package LeetCode.会员.猿辅导;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/26
 */
public class LeetCode429_levelOrder_N叉树层序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        LinkedList<Node> parentQueue = new LinkedList<>();
        LinkedList<Node> childrenQueue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        list = new ArrayList<>();
        parentQueue.add(root);
        while (!parentQueue.isEmpty() || !childrenQueue.isEmpty()){
            root = parentQueue.poll();
            for (Node node : root.children){
                list.add(node.val);
                childrenQueue.add(node);
            }
            if (parentQueue.isEmpty()){
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                parentQueue = childrenQueue;
                childrenQueue = new LinkedList<>();
            }
        }
        return res;
    }


    // 最优，递归
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder2(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }
}
