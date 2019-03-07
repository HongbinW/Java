package queue;
// 出队操作变成O(1)
public class LoopQueue<E> implements queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];       //有意浪费一个空间
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return this.front == this.tail;
    }

    @Override
    public void enqueue(E e){
        if(front == (tail + 1) % this.data.length) {
            resize(this.getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue(){
        if(front == tail){
            throw new RuntimeException("The queue is empty");
        }
        E s = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return s;
    }

    @Override
    public E getFront(){
        if(front == tail){
            throw new RuntimeException("The queue is empty");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < size; i++){                          //两种遍历循环数组方式
            newData[i] = data[(front + i) % data.length];       //将旧队列中队首元素放到新的队列中0的位置
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<Integer>();
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
