import java.util.*;

public class Main{
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < 10; i++){
            queue.offer(i);
        }
        Main(queue);
    }

    public Main(){
        System.out.println(123);
    }
    public static void Main(Queue queue){
        if(queue.size() % 3 == 0){
            System.out.println(queue.size());
            return;
        }
        System.out.println(queue.poll());
        Main(queue);
        System.out.println(queue.poll());
        Main(queue);
    }
}