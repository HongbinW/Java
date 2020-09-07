package LeetCode.classify.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/8
 */
public class LeetCode539_findMinDifference_最小时间差 {
    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        int diff = 0;
        timePoints.sort((a,b)->a.compareTo(b));
        for (int i = 0; i < timePoints.size(); i ++){
            String t1 = timePoints.get(i);
            String t2 = timePoints.get((i+1)%timePoints.size());
            int h1 = (t1.charAt(0) - '0') * 10 + t1.charAt(1) - '0';
            int h2 = (t2.charAt(0) - '0') * 10 + t2.charAt(1) - '0';
            int m1 = (t1.charAt(3) - '0') * 10 + t1.charAt(4) - '0';
            int m2 = (t2.charAt(3) - '0') * 10 + t2.charAt(4) - '0';
            diff = (h2 - h1) * 60 + m2 - m1;
            if (i == timePoints.size()-1){
                diff += 24 * 60;
            }
            res = Math.min(diff,res);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> times = new ArrayList<>();
        times.add("23:59");
        times.add("00:00");

        System.out.println(new LeetCode539_findMinDifference_最小时间差().findMinDifference(times));
    }
}

