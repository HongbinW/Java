package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: HongbinW
 * @Date: 2019/3/19 15:25
 * @Version 1.0
 */
/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 */
public class LeetCode347 {
    //Solution1
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }
        heap.PriorityQueue<Freq> pq = new heap.PriorityQueue<Freq>();     //因为优先队列是大根堆的底层实现，而我们是要将最高的前k高元素取出
                                                                //所以，我们应找到当前这K个元素中频次最低的元素，即小根堆更容易实现
                                                                //但是我们可以在设置其优先级的时候，让频次大的优先级低，即放到堆的下面
        for(int key : map.keySet()){
            if(pq.getSize()<k){
                pq.enqueue(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key,map.get(key)));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.dequeue().e);
        }
        return list;
    }
    private class Freq implements Comparable<Freq>{
        int e,freq;
        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq){       //当前频次越高，优先级越低
                return 1;
            }else if(this.freq > another.freq){
                return -1;
            }else{
                return 0;
            }
        }
    }



}

