package primary.primary4_Tree;

/**
 * @Author: HongbinW
 * @Date: 2019/4/21 22:12
 * @Version 1.0
 * @Description:
 */
public class Code06_CountCBTNodes {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(Node head) {
        if(head == null)
            return 0;
        return bs(head,1,mostLeftLevel(head,1));
    }
        //返回以node为头的整个节点个数
    private static int bs(Node node,int level,int h){   //node当前节点,l在第几层，root为第一层,h为总高度,为一个定值
        if(level == h){ //level来到最后一层，则为叶节点
            return 1;
        }
        if(mostLeftLevel(node.right,level+1) == h){     //该node的右子树的最左的深度，到没到最大的高度
            return (1 << (h - level)) + bs(node.right, level + 1,h);    //左树个数为2^(h-level),+1-1省掉，再递归求右子树
        }else{
            return (1 << (h - level - 1) + bs(node.left,level + 1, h)); //没到h，则说明还少一行，右子树就是2^(h-level-1)，在递归求左子树
        }
    }
    private static int mostLeftLevel(Node node,int level){
        while(node != null){
            level ++;
            node = node.left;
        }
        return level - 1;
    }
}
