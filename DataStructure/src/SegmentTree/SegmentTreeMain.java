package SegmentTree;

public class SegmentTreeMain {
    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree = new SegmentTree<Integer>(nums, (a,b) -> a + b);      //λ表达式
        System.out.println(segTree);
    }
}
