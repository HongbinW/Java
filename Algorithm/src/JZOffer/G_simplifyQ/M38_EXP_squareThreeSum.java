package JZOffer.G_simplifyQ;

public class M38_EXP_squareThreeSum {
    public static void main(String[] args) {
        System.out.println(process(new int[]{1,2,3,2,3,2,1,2},0));
    }

    public static boolean process(int[] arr ,int start){
        if(arr == null || arr.length <= 0 || start >= arr.length)
            return false;
        if(match(arr))
            return true;
        else{
            for(int i = start + 1; i < arr.length; i++){
                swap(arr,i,start);
                process(arr,start+1);
                swap(arr,i,start);
            }
        }
        return false;
    }
    public static boolean match(int[] arr){
        int temp1 = arr[0] + arr[1] + arr[2] + arr[3];
        int temp2 = arr[4] + arr[5] + arr[6] + arr[7];
        int temp3 = arr[0] + arr[2] + arr[4] + arr[6];
        int temp4 = arr[1] + arr[3] + arr[5] + arr[7];
        int temp5 = arr[0] + arr[1] + arr[4] + arr[5];
        int temp6 = arr[2] + arr[3] + arr[6] + arr[7];
        return temp1 == temp2 && temp3 == temp4 && temp5 == temp6;
    }
    public static void swap(int[] arr, int i, int j){
        int tmep = arr[i];
        arr[i] = arr[j];
        arr[j] = tmep;
    }
}
