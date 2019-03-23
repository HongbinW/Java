package AVLTree;
import map.Map;
/**
 * @Author: HongbinW
 * @Date: 2019/3/22 16:07
 * @Version 1.0
 * @Description:
 */
public class AVLMap<K extends Comparable<K>,V> implements Map<K,V>{
    private AVLTree<K,V> avl;
    public AVLMap(){
        avl = new AVLTree<K, V>();
    }

    @Override
    public void add(K key,V value){
        avl.add(key,value);
    }

    @Override
    public V remove(K key){
        return avl.remove(key);
    }

    @Override
    public boolean contains(K key){
        return avl.contains(key);
    }

    @Override
    public V get(K key){
        return avl.get(key);
    }

    @Override
    public void set(K key,V value){
        avl.set(key,value);
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
