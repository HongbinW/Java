package primary.primary7_Greed;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @Author: HongbinW
 * @Date: 2019/4/30 13:47
 * @Version 1.0
 * @Description: 题目四
 */
public class Code04_IPO {
    //一个项目对应一个node
    public static class Node{
        public int profit;
        public int cost;

        public Node(int profit,int cost){
            this.profit = profit;
            this.cost = cost;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node node1, Node node2){
            return node2.cost - node1.cost;     // 升序，传入n1,n2，即n2-n1>0则保持不变
        }
    }

    public static class MaxCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node node1, Node node2){
            return node1.profit - node2.profit;
        }
    }

    public static int findMax(int k, int w, int[] profits, int[] costs){
        Node[] nodes = new Node[profits.length];
        for(int i = 0; i < profits.length; i++){
            nodes[i] = new Node(profits[i],costs[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxCostComparator());
        for(int i = 0; i < nodes.length; i++){
            minCostQ.add(nodes[i]);
        }
        for(int i = 0; i < k ; i++){
            while(!minCostQ.isEmpty() && minCostQ.peek().cost < w){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return w;
            }
            w += maxProfitQ.poll().profit;
        }
        return w;
    }
}
