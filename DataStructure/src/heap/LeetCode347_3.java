package heap;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @Author: HongbinW
 * @Date: 2019/3/19 16:29
 * @Version 1.0
 */
//两种比较方式，一种是实现Comparable接口，并重写compareTo方法
//另一种是实现Comparator接口，然后将其实例传入所用数据结构的构造器中
public class LeetCode347_3 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new FreqComparator());     //因为优先队列是大根堆的底层实现，而我们是要将最高的前k高元素取出
        //所以，我们应找到当前这K个元素中频次最低的元素，即小根堆更容易实现
        //但是我们可以在设置其优先级的时候，让频次大的优先级低，即放到堆的下面
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.remove().e);
        }
        return list;
    }

    private class Freq {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }
        private class FreqComparator implements Comparator<Freq> {
            @Override
            public int compare(Freq a, Freq b) {
                return a.freq - b.freq;
            }
        }
}
