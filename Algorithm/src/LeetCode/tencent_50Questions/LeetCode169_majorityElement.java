package LeetCode.tencent_50Questions;

import java.util.HashMap;

public class LeetCode169_majorityElement {
    //法一：
    public int majorityElement1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }
            int temp = map.get(nums[i]);
            if(temp + 1 > nums.length / 2){
                return nums[i];
            }
            map.put(nums[i],temp + 1);
        }
        return 0;
    }
    //法二：基于摩尔投票器。
    public int majorityElement2(int[] nums) {
        int count=0;//计算当前的数字出现的次数
        int mj=0;//当前判断的元素
        for (int i = 0; i < nums.length; i++)
        {
            if(count==0){//当次数为0时，则换下一判断元素
                mj=nums[i];
                count=1;
            }
            else if (nums[i]==mj) {
                count++;//当前元素等于判断元素，次数加一
            }
            else {
                count--;//不等于则次数减一
            }
        }
        return mj;
    }
}
