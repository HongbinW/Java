package queue;

public class ArrayQueue<E> implements queue<E>{
    private Array<E> array;
    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }
    public ArrayQueue(){
        array = new Array<E>();
    }
    @Override
    public int getSize(){
        return array.getSize();
    }
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front[");
        for(int i = 0; i < array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
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
