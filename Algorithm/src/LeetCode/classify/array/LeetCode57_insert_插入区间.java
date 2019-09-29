package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/25 17:05
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/insert-interval/
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 */
public class LeetCode57_insert_插入区间 {

    //找第一个比target大的下标
    public int binarySearch(int[][] intervals, int target){
        int left = 0;
        int right = intervals.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >>> 1);
            if (intervals[mid][0] > target){
                right = mid;
            }else if (intervals[mid][0] == target){
                return mid;
            }else{
                left = mid + 1;
            }
            if (left == right){
                break;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode57_insert_插入区间().midSearch(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
    }

    public int midSearch(int[][] intervals, int[] newInterval){
        int start = 0;
        int end = intervals.length;
        int mid;
        while (start<end){
            mid = (start+end)/2;
            if(intervals[mid][0]<newInterval[0])
                start = mid+1;
            else
                end = mid;
        }
        return start;
    }
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int count = 1;
        int[] buffer = new int[2];
        buffer[0] = newInterval[0];
        buffer[1] = newInterval[1];
        int place = midSearch(intervals,newInterval);//找到插入位置
        //向后合并
        int temp;
        for(temp = place;temp<intervals.length;temp++){
            if(buffer[1]<intervals[temp][0])
                break;
        }
        if(temp!=place){
            buffer[1] = Math.max(intervals[temp-1][1],buffer[1]);
            count-=temp-place;
        }
        //向前合并
        if (place!=0){
            if(intervals[place-1][1]>=buffer[0]){
                buffer[0] = intervals[place-1][0];
                buffer[1] = Math.max(intervals[place-1][1],buffer[1]);
                place--;
                count--;
            }
        }
        //储存结果
        int target;
        int[][] result = new int[intervals.length+count][2];
        for(target = 0;target<place;target++){
            result[target][0] = intervals[target][0];
            result[target][1] = intervals[target][1];
        }
        result[target][0] = buffer[0];
        result[target][1] = buffer[1];
        target++;
        for(;temp<intervals.length;temp++,target++){
            result[target][0] = intervals[temp][0];
            result[target][1] = intervals[temp][1];
        }
        return result;
    }
}
