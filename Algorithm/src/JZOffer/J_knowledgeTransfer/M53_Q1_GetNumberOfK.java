package JZOffer.J_knowledgeTransfer;

public class M53_Q1_GetNumberOfK {
    public static int GetNumberOfK(int [] array , int k) {
        int first = getFirstOrLastK(array,k,-1,0,array.length-1);
        if(first == -1){
            return 0;
        }
        int last = getFirstOrLastK(array,k,1,0,array.length-1);
        return last - first + 1;
    }

    public static int getFirstOrLastK(int[] arr, int k, int index, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if(arr[mid] > k){
            end = mid - 1;
        }else if(arr[mid] < k){
            start = mid + 1;
        }else{
            if (mid + index < 0 || mid + index > arr.length-1 || arr[mid + index] != k){     //index=-1则看mid的左边是不是k
                return mid;
            }else if(index == -1){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return getFirstOrLastK(arr,k,index,start,end);
    }

    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[]{3,3,3,3,4,5} , 3));
    }
}
