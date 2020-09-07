package LeetCode.每日一题;

import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
public class LeetCode128_longestConsecutive_最长连续序列 {
    // 更优解。直接去set中去找是否有前一个元素，如果有，那么就直接跳过，因为从前一个开始数肯定比现在这个开始数得到的结果更大
    public int longest(int[] nums){
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        int res = 0;
        for(int i : nums){
            if (!set.contains(i)){
                continue;
            }
            int count = 1;
            int cur = i+1;
            while (set.contains(cur)){
                set.remove(cur);
                count++;
                cur ++;
            }
            cur = i - 1;
            while (set.contains(cur)){
                set.remove(cur);
                count ++;
                cur --;
            }
            res = Math.max(res, count);
            set.remove(i);
        }
        return res;
    }
}
