package set;
import Tree.BST;
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }

    @Override
    public void add(E e){
        bst.add(e);         //原方法对添加重复元素不理会
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }
}
