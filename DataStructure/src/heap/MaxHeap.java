package heap;
import queue.Array;
/**
 * Description
 * Author  HongbinW
 * Date 2019/3/16
 */
//用动态数组来实现堆结构，堆是层序遍历的
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;
    public MaxHeap(int capacity){
        data = new Array<E>(capacity);
    }
    public MaxHeap(){
        data = new Array<E>();
    }
    public MaxHeap(E[] arr){
        data = new Array<E>(arr);
        for(int i = parent(arr.length-1); i >= 0; i--){
            siftDown(i);
        }
    }
    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
    //返回父亲、左孩子、右孩子的索引
    private int parent(int index){
        if(index == 0){
            throw new RuntimeException("This is root");
        }
        return (index-1)/2;
    }
    private int leftChild(int index){
        return 2 * index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }
    private void siftUp(int k){
        while(k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }
    //看最大元素
    public E findMax(){
        if(data.isEmpty()){
            throw new RuntimeException("Empty heap.");
        }
        return data.get(0);
    }
    //取出最大元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while(leftChild(k) < data.getSize()){
            int maxIndex = rightChild(k) < data.getSize() && data.get(rightChild(k)).compareTo(data.get(leftChild(k))) > 0
                    ? rightChild(k) : leftChild(k);     //一定要先判断右孩子是否存在，再比较
            if(data.get(k).compareTo(data.get(maxIndex)) < 0){
                data.swap(k,maxIndex);
                k = maxIndex;
            }else{
                break;
            }
        }
    }
    //取出最大元素后，再放入一个新元素
    public E replace(E e){
        E res = findMax();
        data.set(0,e);
        siftDown(0);
        return res;
    }
}
