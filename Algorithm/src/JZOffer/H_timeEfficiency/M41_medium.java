package JZOffer.H_timeEfficiency;

import java.util.PriorityQueue;

public class M41_medium {

    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1,o2)->o2-o1);

    public void Insert(Integer num) {
        if(minQueue.isEmpty()){
            minQueue.offer(num);
        }else{
            if(num >= minQueue.peek()){
                minQueue.offer(num);
            }else{
                maxQueue.offer(num);
            }
        }
        if(minQueue.size() - maxQueue.size() >= 2){
            maxQueue.offer(minQueue.poll());
        }else if(maxQueue.size() - minQueue.size() >= 2){
            minQueue.offer(maxQueue.poll());
        }
    }

    public Double GetMedian() {
        if (minQueue.isEmpty() && maxQueue.isEmpty())
            return null;
        if (minQueue.size() == maxQueue.size())
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        else
            return minQueue.size() > maxQueue.size() ? minQueue.peek() * 1.0 : maxQueue.peek() * 1.0;
    }

    public static void main(String[] args) {
        M41_medium t = new M41_medium();
        t.Insert(5);
        System.out.println(t.GetMedian());
        t.Insert(2);
        System.out.println(t.GetMedian());
    }
}
