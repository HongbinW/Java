package nowcode.byteDance.春招2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/29
 */
public class Main4 {
    static class Node{
        int[] location = new int[2];
        int count = 1;
        Node(int x, int y){
            this.location[0] = x;
            this.location[1] = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i ++){
            ArrayList<ArrayList<Node>> total = new ArrayList<>();
            int M = sc.nextInt();
            for (int j = 0; j < M; j ++){
                int c = sc.nextInt();
                ArrayList<Node> list = new ArrayList<>();
                for (int k = 0; k < c; k ++){
                    list.add(new Node(sc.nextInt(),sc.nextInt()));
                }
                total.add(list);
            }
            System.out.println(process(total));
        }
    }
    public static int process(ArrayList<ArrayList<Node>> total){
        int res = 1;
        ArrayList<Node> compare = total.get(0);
        for (int i = 1; i < total.size(); i ++){
            ArrayList<Node> cur = total.get(i);
            ArrayList<Node> newCompare = new ArrayList<>();
            for (int j = 0; j < cur.size(); j ++){
               Node node = cur.get(j);
               for (int k = 0; k < compare.size(); k ++){
                   if (node.location[0] == compare.get(k).location[0] &&
                           node.location[1] == compare.get(k).location[1]){
                       node.count = Math.max(node.count, compare.get(k).count+1);
                       break;
                   }
               }
               res = Math.max(res, node.count);
               newCompare.add(node);
            }
            compare = newCompare;
        }
        return res;
    }
}
