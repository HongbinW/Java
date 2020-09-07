package examination.美团;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main2 {
    static class Order{
        int id;
        int money;
        Order(int id, int money){
            this.id = id;
            this.money = money;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Order> queue = new PriorityQueue<>((o1, o2) -> o2.money == o1.money ? o1.id - o2.id : o2.money - o1.money);
        for (int i = 0; i < n; i ++){
            queue.add(new Order(i + 1, sc.nextInt() + sc.nextInt() * 2));
        }
        int[] arr = new int[m];
        for (int i = 0; i < m; i ++){
            arr[i] = queue.poll().id;
        }
        Arrays.sort(arr);
        for (int i = 0; i < m; i ++){
            System.out.printf("%d", arr[i]);
            if (i != m-1){
                System.out.printf(" ");
            }
        }
    }
}