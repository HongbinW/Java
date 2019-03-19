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
        //如果传入数组的长度刚好是2^n，则刚好占一层，然后总节点数为2^(n+1)-1,所以大致需要2*length的长度
        //而如果传入的数组所占得叶子节点占了最后两层，则即在上述基础上，再多一层，而多的这一层刚好是上面总长度，所以再乘2
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

    //返回区间[queryL,queryR]的值
    public E query(int queryL, int queryR){
        if(queryL > queryR || queryL < 0 || queryL >= data.length || queryR >= data.length || queryR < 0){
            throw new RuntimeException("Index is illegal.");
        }
        return query(0,0,data.length -1,queryL,queryR);
    }
    //以treeIndex为根的线段树[L,R]的范围内，搜索区间[queryL,queryR]的值
    private E query(int treeIndex, int L, int R, int queryL, int queryR){
        if(L == queryL && R == queryR){
            return tree[treeIndex];
        }
        int mid = L + (R - L) / 2;
        if(queryR <= mid){
            return query(leftChild(treeIndex),L,mid,queryL,queryR);
        }else if(queryL > mid){
            return query(rightChild(treeIndex),mid+1,R,queryL,queryR);
        }else{
            return merger.merge(query(leftChild(treeIndex),L,mid,queryL,mid),
                    query(rightChild(treeIndex),mid+1,R,mid+1,queryR));
        }
    }

    //将index位置的值，更新为e
    public void set(int index,E e){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = e;
        set(0,index,0,data.length-1,e);
    }
    private void set(int treeIndex,int index, int L, int R,E e){
        if(L == R){
            tree[treeIndex] = e;
            return;
        }
        int mid = L + (R - L) / 2;
        if(index >= mid + 1)
            set(rightChild(treeIndex),index, mid + 1, R,e);
        else // index <= mid
            set(leftChild(treeIndex), index, L, mid,e);
        tree[treeIndex] = merger.merge(tree[leftChild(treeIndex)],tree[rightChild(treeIndex)]);
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
