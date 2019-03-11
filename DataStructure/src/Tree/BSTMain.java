package Tree;

import java.util.ArrayList;

public class BSTMain {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,9,1,4,7,14,6,8};
        for(int i = 0; i < nums.length; i++){
            bst.add(nums[i]);
        }
        bst.remove(8);
//        bst.removeMin();
        System.out.println(bst);
    }
}
