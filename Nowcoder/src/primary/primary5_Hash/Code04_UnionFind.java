package primary.primary5_Hash;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/4/29 16:01
 * @Version 1.0
 * @Description:
 */
public class Code04_UnionFind {

    public static class Node{

    }
    public static class UnionFindSet{
        public HashMap<Node,Node> fatherMap;    //key: child    value:father
        public HashMap<Node,Integer> sizeMap;   //该Node所在集合的节点总数，实际存储代表节点和所在集合的节点总数

        public UnionFindSet(List<Node> nodes){
            makeSets(nodes);
        }
        //初始化
        public void makeSets(List<Node> nodes){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for(Node node : nodes){
                fatherMap.put(node,node);   //每一个node先自己形成一个集合
                sizeMap.put(node,1);
            }
        }

        private Node findHeadDG(Node node){
            Node father = fatherMap.get(node);
            if(father != node){
                father = findHeadDG(father);  //最终father会是代表节点
            }
            fatherMap.put(node,father);     //更新沿途节点的父节点
            return father;
        }

        private Node findHead(Node node){
            Node father = fatherMap.get(node);
            Node cur = node;
            Stack<Node> stack = new Stack<>();
            while(father != cur){
                stack.push(cur);
                cur = father;
                father = fatherMap.get(cur);
            }
            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(),father);
            }
            return father;
        }

        public boolean isSameSet(Node a,Node b){
            return findHead(a) == findHead(b);
        }

        public void union(Node a,Node b){
            if(a == null || b == null)
                return;
            Node aHead = findHead(a);
            Node bHead = findHead(b);

            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if(aSetSize < bSetSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead,aSetSize+bSetSize);
                    //只有代表节点的size才是有效信息，其余的可删
                    sizeMap.remove(aHead);
                }else{
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSetSize+bSetSize);
                    sizeMap.remove(bHead);
                }
            }
        }
    }
}
