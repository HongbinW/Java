package heap;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @Author: HongbinW
 * @Date: 2019/3/19 16:38
 * @Version 1.0
 */
public class LeetCode347_4 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        }
        );
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }
        return list;
    }

}
