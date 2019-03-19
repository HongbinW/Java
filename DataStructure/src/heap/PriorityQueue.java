package heap;
import queue.queue;

import java.nio.channels.Pipe;

/**
 * @Author: HongbinW
 * @Date: 2019/3/18 17:47
 * @Version 1.0
 */
public class PriorityQueue<E extends Comparable<E>> implements queue<E>{
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }
    public PriorityQueue(int capacity){
        maxHeap = new MaxHeap<>(capacity);
    }

    @Override
    public int getSize(){
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

    @Override
    public E dequeue(){
        return maxHeap.extractMax();
    }

    @Override
    public E getFront(){
        return maxHeap.findMax();
    }
}
