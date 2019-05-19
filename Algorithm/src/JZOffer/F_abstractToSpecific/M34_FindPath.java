package JZOffer.F_abstractToSpecific;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class M34_FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //层序便利二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            //问题：怎么最有效地保存之前的结果
        }
        return res;
    }

    //递归，OJ成功！
    public static ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        process(root,target,list,res);
        return res;
    }
    private static void process(TreeNode root,int target,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){
        if(target < 0){
            list.remove(list.size()-1);
            return;
        }else{
            list.add(root.val);
            if(root.left == null && root.right == null){
                if(target - root.val == 0){
                    res.add(list);
                    return;
                }else {
                    list.remove(list.size() - 1);
                    return;
                }
            }
            if(root.left != null){
                ArrayList<Integer> list1 = new ArrayList<>();
                for(int ele : list){
                    list1.add(ele);
                }
                process(root.left,target-root.val,list1,res);
            }
            if(root.right != null){
                ArrayList<Integer> list2 = new ArrayList<>();
                for(int ele : list){
                    list2.add(ele);
                }
                process(root.right,target-root.val,list2,res);
            }   //其实也可以在每次要往回返回的时候，把路径中的当前路径删掉
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        node.right = new TreeNode(12);
        FindPath2(node,22);
    }
}
