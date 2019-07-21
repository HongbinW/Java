package primary;

class Solution {
    public int InversePairs(int [] array) {
        if(array == null || array.length < 2){
            return 0;
        }
        return process(array,0,array.length-1) % 1000000007;
    }

    public int process(int[] array, int L, int R){
        if(L == R){
            return 0;
        }
        int mid = L + ((R - L) >>> 1);
        return process(array,L,mid) % 1000000007 + process(array,mid + 1,R) % 1000000007 + merge(array,L,mid,R) % 1000000007;
    }

    public int merge(int[] arr, int start, int mid, int end){
        int count = 0;
        int[] help = new int[end - start + 1];
        int index = 0;
        int left = start;
        int right =  mid + 1;
        while(left <= mid && right <= end){
            if(arr[left] > arr[right]){
                count += mid - left + 1;
                help[index++] = arr[right ++];
            }else{
                help[index++] = arr[left ++];
            }
        }
        while(left <= mid){
            help[index++] = arr[left ++];
        }
        while(right <= end){
            help[index++] = arr[right ++];
        }
        for(int i = 0; i < help.length; i ++){
            arr[start + i] = help[i];
        }
        return count % 1000000007;
    }
}

public class TEST{
    public static void main(String[] args) {
        System.out.println(new Solution().InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}


