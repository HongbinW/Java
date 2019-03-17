
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Test {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    private static TreeNode reConstructBinaryTree(int[] pre, int startpre, int endpre, int[] in, int startin, int endin){
        if(startpre > endpre || startin > endin){
            return null;
        }
        TreeNode node = new TreeNode(pre[startpre]);
        for(int i = startin; i <= endin ; i++){
            if(pre[startpre] == in[i]){
                node.left = reConstructBinaryTree(pre,startpre+1,startpre+i-startin,in,startin,i-1);
                node.right = reConstructBinaryTree(pre,startpre+i-startin+1,endpre,in,i+1,endin);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre,in);
        System.out.println("fuck");
    }
}