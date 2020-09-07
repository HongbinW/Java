package LeetCode.casuallly;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/6
 */
public class LeetCode347_topKFrequent_前k个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        int index = 0;
        for(int i = list.length - 1;i >= 0 && index < k;i--){
            if(list[i] == null) continue;
            for (int data : list[i]){
                res[index++] = data;
            }
        }
        return res;
    }

}
