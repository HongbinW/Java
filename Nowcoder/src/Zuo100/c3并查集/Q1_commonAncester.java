package Zuo100.c3并查集;

/**
 * @Author: HongbinW
 * @Date: 2019/8/4 22:25
 * @Version 1.0
 * @Description:
 */
public class Q1_commonAncester {
    class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }
    class Query{
        public Node o1;
        public Node o2;
        public Query(Node o1, Node o2){
            this.o1 = o1;
            this.o2 = o2;
        }
    }

    public static Node[] findCommonAncester(Query[] q){

    }
}
