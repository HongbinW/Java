package heap;
import java.util.*;
import java.util.PriorityQueue;

/**
 * @Author: HongbinW
 * @Date: 2019/3/19 15:52
 * @Version 1.0
 */

//使用java自带的Priority queue 其低层实现是最小堆
public class LeetCode347_2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();     //因为优先队列是大根堆的底层实现，而我们是要将最高的前k高元素取出
        //所以，我们应找到当前这K个元素中频次最低的元素，即小根堆更容易实现
        //但是我们可以在设置其优先级的时候，让频次大的优先级低，即放到堆的下面
        for(int key : map.keySet()){
            if(pq.size()<k){
                pq.add(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key,map.get(key)));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.remove().e);
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
        public int compareTo(Freq another){     //根据最小堆，应频次越低越靠上，
            if(this.freq < another.freq){
                return -1;
            }else if(this.freq > another.freq){
                return 1;
            }else{
                return 0;
            }
        }
    }


}
