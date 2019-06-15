package JZOffer.J_knowledgeTransfer;

public class M53_Q3_GetNumberSameAsIndex {
    public int getNumberSameAsIndex(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] > mid){
                right = mid - 1;
            }else if(arr[mid] < mid){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
