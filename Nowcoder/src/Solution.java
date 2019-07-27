import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{3,8,4,5,6,1,2};
        maxScore(arr);
        for (int i = 0; i < res.size(); i ++){
            System.out.print(res.get(i) + "  ");
            System.out.println(res.get(i+1));
        }
    }
    public static void maxScore(int[] arr){
        for (int ele : arr){
            sumAll += ele;
        }
        process(arr,0,arr.length-1);
    }

    static ArrayList<Integer> temp = new ArrayList<>();
    static ArrayList<Integer> res = new ArrayList<>();
    static int sumAll = 0;

    public static void process(int[] arr, int start, int end){
        if (start > end){
            int sum = 0;
            for (int ele : temp){
                sum += ele;
            }
            res.add(sum,sumAll-sum);
            return;
        }
        temp.add(arr[start]);
        process(arr,start+1,end);
        temp.remove(temp.size()-1);
        temp.add(arr[end]);
        process(arr,start,end-1);
        temp.remove(temp.size()-1);
    }
}