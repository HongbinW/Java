package stack;
import linkedlist.LinkedList;

public class linkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public linkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public E pop(){
        return list.removeFirst();
    }

    @Override
    public void push(E e){
        list.addFirst(e);
    }

    @Override
    public E peek(){
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);       //list的toString
        return res.toString();
    }

}
