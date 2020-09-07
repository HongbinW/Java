package LeetCode.每日一题;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/11
 */
public class LeetCode315_countSmaller_右侧小于当前元素的个数 {
    public static void main(String[] args) {
        List<Integer> res = new LeetCode315_countSmaller_右侧小于当前元素的个数().countSmaller(new int[]{2,0,1});
        for (int i : res){
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    // 官方答案，就是把nums[i]的值域分成一个个桶，然后从后往前取数，记录各桶内的个数，同时维护好一个前缀和
    private int[] c;
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }

//    public List<Integer> countSmaller(int[] nums) {
//        LinkedList<Integer> list = new LinkedList<>();
//        if (nums.length == 0){
//            return list;
//        }
//        list.add(0);
//        LinkedList<Integer> s = new LinkedList<>();
//        s.add(nums[nums.length-1]);
//        for (int i = nums.length - 2; i >= 0; i --){
//            if (nums[i] > s.peekLast()){
//                list.addFirst(s.size());
//                s.addLast(nums[i]);
//            }else if (nums[i] < s.peekFirst()){
//                list.addFirst(0);
//                s.addFirst(nums[i]);
//            }else {
//                int index = midSearch(s, nums[i]);
//                list.addFirst(index);
//                s.add(index, nums[i]);
//            }
//        }
//        return list;
//    }
//    public int midSearch(LinkedList<Integer> list, int target){
//        int left = 0;
//        int right = list.size() - 1;
//        while (left < right){
//            int mid = left + (right - left) / 2;
//            if (list.get(mid) > target){
//                right = mid;
//            }else{
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
}
