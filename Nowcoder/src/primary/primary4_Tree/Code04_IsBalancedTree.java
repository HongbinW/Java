package primary.primary4_Tree;

/**
 * @Author: HongbinW
 * @Date: 2019/4/21 20:59
 * @Version 1.0
 * @Description:
 */
public class Code04_IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //通用！其实可以把这俩融合成一个信息，比如如果返回-1，则说明不平衡
    public static class ReturnData{
        public boolean isB;
        public int h;

        public ReturnData(boolean isB,int h){
            this.h = h;
            this.isB = isB;
        }
    }
    public static boolean isBalanced(Node head){
        return process(head).isB;
    }
    public static ReturnData process(Node head){
        if(head == null)
            return new ReturnData(true,0);
        ReturnData leftData = process(head.left);
        if(!leftData.isB)
            return new ReturnData(false,0); //h是什么无所谓了
        ReturnData rightData = process(head.right);
        if(!rightData.isB)
            return new ReturnData(false,0);
        if(Math.abs(leftData.h - rightData.h) > 1)
            return new ReturnData(false,0);
        return new ReturnData(true,Math.max(leftData.h,rightData.h) + 1);
    }

}
