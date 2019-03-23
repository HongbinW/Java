package AVLTree;
import set.Set;
/**
 * @Author: HongbinW
 * @Date: 2019/3/22 16:17
 * @Version 1.0
 * @Description:
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E,Object> avl;

    public AVLSet(){
        avl = new AVLTree<E, Object>();
    }

    @Override
    public void add(E e){
        avl.add(e,null);
    }

    @Override
    public void remove(E e){
        avl.remove(e);
    }

    @Override
    public boolean contains(E e){
        return avl.contains(e);
    }

    @Override
    public int getSize(){
        return avl.getSize();
    }

    @Override
    public boolean isEmpty(){
        return avl.isEmpty();
    }
}
