package JZOffer.H_timeEfficiency;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class M40_GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k > input.length || k <= 0){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < input.length; i++){
            queue.offer(input[i]);
            if (queue.size() > k)
                queue.poll();
        }
        return new ArrayList<>(queue);
    }

    //法二：
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k <= 0 || k > input.length)
            return list;
        int temp = process(input,k);
        for(int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }
    public static int process(int[] arr , int k){
        int start = 0, end = arr.length - 1;
        int temp = partition(arr,start,end);
        while (true){
            if(temp > k){
                if (temp-1 < start)
                    break;
                temp = partition(arr,start,temp - 1);
            }else if (temp < k){
                if (temp + 1 > end)
                    break;
                temp = partition(arr,temp + 1,end);
            }else {
                return temp;
            }
        }
        return -1;
    }

    public static int partition(int[] arr, int start, int end){
        int less = start - 1;
        int more = end;
        while (start < more){
            if(arr[start] > arr[end]){
                swap(arr,start,--more);
            }else if(arr[start] < arr[end]){
                swap(arr,++less,start++);
            }else{
                start++;
            }
        }
        swap(arr,start,end);
        return start;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = GetLeastNumbers_Solution2(new int[]{2,3,4,8,62,4,79,5,67,45},6);
        for (int ele : list){
            System.out.println(ele);
        }
    }
}
