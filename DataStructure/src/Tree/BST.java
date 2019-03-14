package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二分搜索树
public class BST <E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //向二分搜索树中添加新元素

    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size ++;
//        }else{
//            add(root,e);
//        }
        root = add(root,e);
    }
    //向以node为根的二分搜索树中插入元素e，递归算法
//    private void add(Node node,E e){
//        //递归终止条件
//        if(e.equals(node.e)){
//            return;
//        }
//        if(node.e.compareTo(e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size ++;
//            return;
//        }else if(node.e.compareTo(e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//        //递归调用
//        if(e.compareTo(node.e) < 0){
//            add(node.left,e);
//        }else{
//            add(node.right,e);
//        }
//    }
    //改进
    //向以node为根的二分搜索树中插入元素e，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){        //其实，如果是要插入最底下的节点，则原来节点不变，返回时还是返回的原来的节点
            node.left = add(node.left,e);
        }
        else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }
    //树，他一定会新建节点，而不会去移动之前的节点

    public boolean contains(E e){
        return contains(root,e);
    }
    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //非递归
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        if(root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //二分搜索树的中序遍历    :结果为从小到大排序
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();     //Queue本身是个接口，选择链表方式实现
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.e);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    //返回二分搜索树的最小元素
    public E minimum(){
       return minimum(root) == null ? null : minimum(root).e;
    }
    private Node minimum(Node node){
        if(node == null)
            return null;
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //返回二分搜索树的最大元素
    public E maximum(){
        return maximum(root) == null ? null : maximum(root).e;
    }
    private Node maximum(Node node){
        if(root == null)
            return null;
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    //删除二分搜索树的最小节点
    public E removeMin(){
        E res = minimum();
        root = removeMin(root);
        return res;
    }
    //删除以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;        //若是最小节点，则返回rightNode,否则，还是返回原来的node，保持原来结构不变
    }

    //删除二分搜索树的最大节点
    public E removeMax(){
        E res = maximum();
        root = removeMax(root);
        return res;
    }
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //删除二分搜索树中任意一个节点
    //若该节点既有左子树又有右子树，则选择右子树中最小的（最左的）那个节点来替换该节点,当然也可以用左子树中最大的
    public void remove(E e){
        root = remove(root,e);
    }
    //删除以node为根的二分搜索树中的值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) == 0){
            Node newNode = minimum(node.right);
            if(newNode == null){
                newNode = node.left;
                size --;
                node.left = null;
                return newNode;
            }
            newNode.right = removeMin(node.right);
            newNode.left = node.left;   //左右不可调换，因为此时newNode指的是树中的节点，则如果先进行左传递，
            node = null;                //则6会直接挂到8的下面，这样在再执行removeMin时，删除的是新节点6
            return newNode;
        }
        else if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
        }else{
            node.right = remove(node.right,e);
        }
        return node;
    }

    /**
     * 在二分搜索树中找出比指定元素e大的最小值
     */
    public E ceil(E e){

        return null;
    }
    private Node ceil(Node node,E e){
        if(node == null){

        }
        if(e.compareTo(node.e) < 0){
            node.left = ceil(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = ceil(node.right,e);
        }
        return null;
    }

    /**
     * 在二分搜索树中找出比指定元素e小的最大值
     */


    /**
     * 在二分搜索树中查询指定元素排名第几
     */
    public int rank(E e){
        return 0;
    }

    /**
     * 在二分搜索树中查询排名第index的元素是谁
     * note:对于rank和select，可以在node节点中多加一个size变量，用来指示以该节点为根节点的树中 吧有多少个节点
     */
    public E select(int index){
        return null;
    }

    //基于前序遍历的toString方法
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1, res);
        generateBSTString(node.right,depth + 1,res);
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i ++){
            res.append("--");
        }
        return res.toString();
    }
}
