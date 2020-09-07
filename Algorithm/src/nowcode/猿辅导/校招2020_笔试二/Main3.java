package nowcode.猿辅导.校招2020_笔试二;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/19
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int i = 0; i < c; i ++){
            int n = sc.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
            for (int j = 0; j < n; j ++){
                queue.add(sc.nextInt());
            }
            int res = 0;
            while (queue.size() >= 3){
                int one = queue.poll();
                int two = queue.poll();
                int three = queue.poll();
                res += three;
                queue.add(one-three);
                queue.add(two-three);
            }
            System.out.println(res);
        }
    }
}


class Main_Solution{
    public static void main(String[] args){
        Scanner input;
        int C, T, i, j;
        int[][] P;

        input = new Scanner(System.in);
        C = input.nextInt();
        P = new int[C][];
        for(i = 0; i < C; i++){
            T = input.nextInt();
            P[i] = new int[T];
            for(j = 0; j < T; j++){
                P[i][j] = input.nextInt();
            }
        }
        for(i = 0; i < C; i++){
            System.out.println(solve(P[i]));
        }
        input.close();
    }

    private static int solve(int[] P){
        int first, second, third, ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> b-a);

        for(int p : P) {
            if(p > 0)pq.offer(p);
        }

        while(pq.size() > 2){
            first = pq.poll();
            second = pq.poll();
            third = pq.poll();
            if(--first > 0){        // 每次减一个
                pq.offer(first);
            }
            if(--second > 0){
                pq.offer(second);
            }
            if(--third > 0){
                pq.offer(third);
            }
            ans++;
        }
        return ans;
    }
}
