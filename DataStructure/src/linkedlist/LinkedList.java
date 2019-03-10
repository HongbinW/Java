package linkedlist;

public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

     // 获取链表中元素的个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //在链表的第index位置添加新的元素e
//    public void add(E e,int index){
//        if(index < 0 || index > size){
//            throw new IllegalArgumentException("Add failed. Illegal index");
//        }
//        Node prev = dummyHead;
//        for (int i = 0; i < index; i++) {   //i=0相当于走到了实际的头结点，所以实际第n个元素对应i-1，所以实际上index还是从0开始
//            prev = prev.next;
//        }
//        prev.next = new Node(e, prev.next);
//        size ++;
//    }
    /**
     * 尝试用递归实现添加操作
     */

    public void add(E e,int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        dummyHead.next = add(e,index,dummyHead.next);
    }
    private Node add(E e,int index,Node head){
        if(index == 0){
            size ++;
            Node node = new Node(e);
            node.next = head;
            return node;
        }
        head.next = add(e,--index,head.next);
        return head;
    }

    //在链表头添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = dummyHead;
//        dummyHead = node;
        add(e,0);
    }

    //在链表末尾添加新的元素e
    public void addLast(E e){
        add(e,size);
    }

    //获得链表的第index个位置的元素
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node node = dummyHead;
        for(int i = 0; i <= index; i++){
            node = node.next;
        }
        return node.e;
    }

    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //修改链表的第index（从0开始）位置的元素为e
    public void set(E e, int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        Node cur = dummyHead;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node node = dummyHead.next;
        while(node != null){    //当前node节点是有效节点
            if(node.e.equals(e)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyHead.next; cur != null; cur = cur.next){
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }

    //删除第index位置的元素，并返回删除的元素
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Illegal index");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }

    //删除第一个元素，并返回删除元素
    public E removeFirst(){
        return remove(0);
    }

    //删除最后一个元素，并返回删除元素
    public E removeLast(){
        return remove(size - 1);
    }
}
