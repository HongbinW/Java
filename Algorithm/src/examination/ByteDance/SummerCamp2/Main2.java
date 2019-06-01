package examination.ByteDance.SummerCamp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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