package JZOffer.J_knowledgeTransfer;

import java.util.LinkedList;

//未OJ
public class M59_Q2_QueueMax {
    private LinkedList<Integer> data;
    private LinkedList<Integer> max;

    public Integer getMax(){
        if (data.isEmpty()){
            throw new RuntimeException("The queue is empty.");
        }
        return max.pollFirst();
    }

    public void push_back(Integer t){
        data.addLast(t);
        while (!max.isEmpty() && max.peekLast() < t){
            max.pollLast();
        }
        max.addLast(t);
    }

    public int pop_front(){
        int res = data.pollFirst();
        if (res == max.peekFirst()){        //如果不是最顶上元素，按照队列先进先出的原则，说明之前已经被踢出去了
            max.pollFirst();
        }
        return res;
    }
}
