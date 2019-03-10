package Tree;
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
