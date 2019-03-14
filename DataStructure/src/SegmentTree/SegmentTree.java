package SegmentTree;

public class SegmentTree<E>{
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }

        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0,0,data.length-1);
    }
    //在treeIndex的位置创建表示区间[L,R]的线段树
    private void buildSegmentTree(int treeIndex, int L, int R) {  //该节点，所要表示的左右端点
        if(L == R) {
            tree[treeIndex] = data[L];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);       //类似堆找该节点在数组中的位置
        int rightTreeIndex = rightChild(treeIndex);
        int mid = L + (R - L) / 2;
        buildSegmentTree(leftTreeIndex,L,mid);
        buildSegmentTree(rightTreeIndex,mid+1,R);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]); //根据具体业务而定，具体可根据实现Merger的类
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length){
            throw new RuntimeException("Index is illegal.");
        }
        return data[index];
    }

    //返回完全二叉树的数组中一个表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2 * index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 2;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
