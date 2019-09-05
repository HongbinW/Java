package goodQuestion.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/5 9:46
 * @Version 1.0
 * @Description:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class subSequence_子集 {
    //整形数组
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        for (int i = 0 ; i < nums.length; i ++) {
            for (int j = res.size() - 1; j >= 0; j --){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    //字符串
    public static List<String> print(char[] chs){
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < chs.length; i ++){
            for (int j = list.size() - 1; j >= 0; j--){
                list.add(list.get(j) + chs[i]);
            }
        }
        return list;
    }
}
