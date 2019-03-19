package heap;
import java.util.*;
import java.util.PriorityQueue;
/**
 * @Author: HongbinW
 * @Date: 2019/3/19 17:28
 * @Version 1.0
 */
public class LeetCode347_5 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                (a,b) -> map.get(a) - map.get(b)
        );     //因为优先队列是大根堆的底层实现，而我们是要将最高的前k高元素取出
        //所以，我们应找到当前这K个元素中频次最低的元素，即小根堆更容易实现
        //但是我们可以在设置其优先级的时候，让频次大的优先级低，即放到堆的下面
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
