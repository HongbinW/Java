package Zuo100.c8_bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q1_xyBothGT {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public ArrayList<Node> solve(Node[] nodes){
        Arrays.sort(nodes,new MyComparator());
        ArrayList<Node> list = new ArrayList<>();
        list.add(nodes[nodes.length-1]);
        int y = nodes[nodes.length-1].y;
        for (int i = nodes.length-2; i >= 0; i --){
            if (nodes[i].y >= y){
                y = nodes[i].y;
                list.add(nodes[i]);
            }
        }
        return list;
    }

    class MyComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.x > o2.x){
                return 1;
            }else if (o1.x < o2.x){
                return -1;
            }else if (o1.y >= o2.y){
                return -1;
            }else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        nodes[0] = new Node(2,2);
        nodes[1] = new Node(3,3);
        nodes[2] = new Node(3,2);
        nodes[3] = new Node(3,1);
        nodes[4] = new Node(4,2);
        ArrayList<Node> list = new Q1_xyBothGT().solve(nodes);
        for (Node node : list){
            System.out.println(node.x+ " "+node.y);
        }

    }
}
