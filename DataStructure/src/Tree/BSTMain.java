package Tree;

public class BSTMain {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,2,4,8};
        for(int i = 0; i < nums.length; i++){
            bst.add(nums[i]);
        }
        bst.preOrder();
        System.out.println();
        System.out.println(bst);
    }
}
