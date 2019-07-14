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
        if(input == null || input.length < k || k <= 0){
            return list;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input,start,end);
        while(index+1 != k){
            if(index+1 < k){
                start = index + 1;
                index = partition(input,start,end);
            }else if(index+1 > k){
                end = index - 1;
                index = partition(input,start,end);
            }
        }
        for(int i = 0 ; i < index + 1; i ++){
            list.add(input[i]);
        }
        return list;
    }
    public static int partition(int[] arr, int start, int end){
        int less = start;
        int more = end;
        int index = start;
        while(less < more){
            if(arr[index] < arr[end]){
                swap(arr,index++,less++);
            }else if(arr[index] > arr[end]){
                swap(arr,index,--more);
            }else{
                index ++;
            }
        }
        swap(arr,end,more);
        return less;    //返回第k大的索引
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
