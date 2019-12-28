package Zuo100.c9;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2019/12/15
 */
public class Q1_TOPK {
    class Node{
        public String str;
        public int times;
        public Node(String str, int times){
            this.str = str;
            this.times = times;
        }
    }
//    PriorityQueue<Map.Entry<String,Integer>> topk;
    Node[] topk;
    HashMap<String,Node> timesMap;
    HashMap<Node,Integer> location;
    int k;
    int size;
    public Q1_TOPK(int k){
        this.topk = new Node[k];
        this.timesMap = new HashMap<String,Node>();
        this.location = new HashMap<Node,Integer>();
        this.k = k;
        this.size = 0;
    }

    public void add(String str){
        int preIndex = -1;
        Node curNode = null;
       //词频统计
       if (!timesMap.containsKey(str)){
           curNode = new Node(str,1);
           timesMap.put(str,curNode);
           location.put(curNode,-1);
       }else{
           curNode = timesMap.get(str);
           curNode.times ++;
           preIndex = location.get(str);
       }
       //如果新进元素不在堆内
       if (preIndex == -1) {
           //堆满了
           if (size == k) {
               if (topk[0].times < curNode.times) {
                   location.put(topk[0], -1);
                   location.put(curNode, 0);
                   topk[0] = curNode;
                   heapify(topk, 0);
               }
           } else {
               location.put(curNode, size);
               topk[size] = curNode;
               heapInsert(topk, curNode);
               size++;
           }
       }else {
           heapify(topk,preIndex);
       }
    }
    public void printTopK(){
        for (int i = 0; i < size; i ++){
            System.out.println(topk[i].str);
        }
    }


    //小根堆
    public void heapify(Node[] nodes, int index){
        int left = 2 * index + 1;
        while (index < size){
            int largest = left + 1 < size && nodes[left].times < nodes[left+1].times ? left + 1 : left;
            largest = nodes[largest].times > nodes[index].times ? largest : index;
            if (index == largest){
                break;
            }
            swap(nodes,index,largest);
            index = largest;
            left = 2 * index + 1;
        }
    }
    public void heapInsert(Node[] nodes, Node node){
        int index = size;
        size ++;
        while (index >= 0 && node.times < nodes[(index-1)/2].times){
            swap(nodes,(index-1)/2,index);
        }
    }
    public void swap(Node[] nodes, int i, int j){
        location.put(nodes[i],j);
        location.put(nodes[j],i);
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }
    public static void main(String[] args) {

    }

}
