package examination.大疆;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[][] paths = new int[P][3];
        for (int i = 0; i < P; i ++){
            for (int j = 0; j < 3; j ++){
                paths[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        System.out.println(process(paths,N,P,target));
    }
    static class Node{
        int from;
        int to;
        int cost;
        Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static int process(int[][] paths, int N, int P, int target){
        HashMap<Integer,List<Node>> map = new HashMap<>();
        for (int i = 0; i < P; i ++){
            if (map.containsKey(paths[i][1])){
                map.get(paths[i][1]).add(new Node(paths[i][0],paths[i][1],paths[i][2]));
            }else{
                List<Node> tmp = new ArrayList<>();
                tmp.add(new Node(paths[i][0],paths[i][1],paths[i][2]));
                map.put(paths[i][1], tmp);
            }
        }
        boolean[] visited = new boolean[N];
        return findMin(map, target, visited);
    }
    public static int findMin(HashMap<Integer,List<Node>> map, int to, boolean[] visited){
        if (visited[to]){
            return 1000;
        }
        visited[to] = true;
        int cost = 1000;
        for (Node node : map.get(to)){
            if (node.from == 0){
                cost = Math.min(cost,node.cost);
            }else{
                cost = Math.min(cost,findMin(map,node.from,visited) + node.cost);
            }
        }
        visited[to] = false;
        return cost;
    }
}