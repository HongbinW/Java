// 找第k大的数，partition解法
public class Test{
    public static void main(String[] args) {
        int[] arr = new int[]{2,34,7,3,1,2,68,8,5,3,23};
        int temp = process(arr,arr.length-3);
        System.out.println(temp != -1 ? arr[temp] : -1);;
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
}