package JZOffer.J_knowledgeTransfer;

public class M53_Q2_GetMissingNumber {
    public int getMissingNumber(int[] arr){
        //找第一个不在自己位置上的数字
        return getFirstWrongNumber(arr,0,arr.length - 1);
    }

    public int getFirstWrongNumber(int[] arr, int start, int end){
        if(start > end){
            return -1;
        }
        if (start == end){
            return start;
        }
        int mid = start + ((end - start) >> 1);
        if(arr[mid] != mid){
            end = mid;
        }else{
            start = mid + 1;
        }
        return getFirstWrongNumber(arr,start,end);
    }

    public static void main(String[] args) {
        M53_Q2_GetMissingNumber test = new M53_Q2_GetMissingNumber();
        System.out.println(test.getMissingNumber(new int[]{0,1,2,3,4,5,7}));
    }
}
