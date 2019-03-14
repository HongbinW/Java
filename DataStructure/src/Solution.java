import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums1){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }
            else{
                map.put(num,1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) != 0){
                list.add(num);
                map.put(num,map.get(num) - 1);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        Solution s = new Solution();
        s.intersection(nums1,nums2);
    }
}