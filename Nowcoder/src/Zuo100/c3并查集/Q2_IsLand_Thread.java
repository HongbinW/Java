package Zuo100.c3并查集;

import java.util.HashMap;

/**
 * @Author: HongbinW
 * @Date: 2019/8/4 21:56
 * @Version 1.0
 * @Description:
 */
public class Q2_IsLand_Thread {
    HashMap<Node,Node> fatherMap = new HashMap<>();     //子节点--->父节点
    HashMap<Node,Integer> rankMap = new HashMap<>();    //节点个数

    class Node{
        Node left;
        Node right;
        int value;
        public Node(int data){
            this.value = data;
        }
    }

    public Node findFather(Node node){
        Node father = fatherMap.get(node);
        if (father != node){
            findFather(father);
        }
        fatherMap.put(node,father);     //在查找父节点的过程中，将所有该分支的节点全都直接指向最终的父节点
        return father;
    }

    public void union(Node node1, Node node2){
        if (node1 == null || node2 == null)
            return;
        Node father1 = findFather(node1);
        Node father2 = findFather(node2);
        if (father1 == father2){
            return;
        }else{
            int rank1 = rankMap.get(father1);
            int rank2 = rankMap.get(father2);
            if (rank1 >= rank2){
                fatherMap.put(node2,node1);
                rankMap.put(node1,rank1+rank2);
            }else{
                fatherMap.put(node1, node2);
                rankMap.put(node2,rank1+rank2);
            }
        }
    }
}
