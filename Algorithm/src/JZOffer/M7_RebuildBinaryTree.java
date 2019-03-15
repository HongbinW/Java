package JZOffer;

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class M7_RebuildBinaryTree {
    private class Q{
        public Node RebuildBinaryTree(int[] prevOrder, int[] inOrder){
            return RebuildBinaryTree(prevOrder,inOrder,0,prevOrder.length-1,0);
        }
        //在inOrder的[L,R)的范围内，找与prevOrder[curRoot]相等的值为当前节点的值
        private Node RebuildBinaryTree(int[] prevOrder, int[] inOrder, int L, int R, int curRoot){
            if(L >= R)
                return null;
            int i = 0;
            for(;i+L<=R;i++){
                if(inOrder[i+L] == prevOrder[curRoot])
                    break;
            }
            Node node = new Node(prevOrder[curRoot]);
            node.left = RebuildBinaryTree(prevOrder,inOrder,L,L+i,1+curRoot);
            if(node.val == inOrder[L+i] && node.left != null){
                curRoot += i;
            }
            node.right = RebuildBinaryTree(prevOrder,inOrder,L+i+1,R,curRoot+1);
            return node;
        }
        //问题：左子树可以建立，根节点的右子树，curRoot容易跳出去
    }

    public static void main(String[] args) {
        int[] prevOrder = {1,2,3,4,5,6,7};
        int[] inOrder = {3,2,4,1,6,5,7};
        new M7_RebuildBinaryTree().new Q().RebuildBinaryTree(prevOrder,inOrder);
    }
}
