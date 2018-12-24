package primary;

public class TestDiGui {
    //找最大值，先找左边最大值，再找右边最大值，然后再去这两个的最大值
    public static int getMax(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        int mid = (L + R)/2;
        int maxLeft = getMax(arr,L,mid);
        int maxRight = getMax(arr,mid+1,R);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args){
        int[] arr = {4,6,3,2,1,7,8};
        System.out.println(getMax(arr,0,arr.length - 1));
    }
}
