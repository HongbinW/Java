package examination.ByteDance.SummerCamp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
通过率0%
输入有很大的问题。
一个树形迷宫，第一行输入N个节点，Q个查询
接下来输入N个节点的值
再输入这个树形结构时什么样的，比如1 3 a 则表示，从节点1到节点3，路径标志为a
最后输入Q个查询,表示从哪个节点出发。
只能从父节点走向子节点。输出从查询所指节点开始所能获得的最大value和。

应该类似给一个LeetCode三角形的数组，然后利用动态规划，从底向上，去计算每个节点能获得的最大值。
 */
class Node{
    int value;
    HashMap<Node,Character> map = new HashMap<>(); //指向节点的位置
    public Node(int value){
        this.value = value;
    }
}
public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int N = sc.nextInt();
            int Q = sc.nextInt();
            ArrayList<Node> list = new ArrayList<>();
            for (int i = 0; i < N; i++){
                list.add(new Node(sc.nextInt()));
            }
            HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
            ArrayList<Integer> temp = new ArrayList();
            temp.add(list.get(0).value);
            map.put(1,temp);
            int pre = 0;
            for (int i = 0; i < N - 1; i++){
                int from = sc.nextInt();
                if(from != pre){
                    map.put(pre,temp);
                    temp = new ArrayList<>();
                    pre = from;
                }
                int to = sc.nextInt();
                temp.add(list.get(to).value);
            }

        }
    }
}