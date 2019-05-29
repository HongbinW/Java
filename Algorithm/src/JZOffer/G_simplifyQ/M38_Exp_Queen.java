package JZOffer.G_simplifyQ;

public class M38_Exp_Queen {
    static int res = 0;
    static int count = 0;
    public static int kinds(){
        int[] arr = new int[8];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        process(arr,0);
        return res;
    }
    public static void process(int[] arr, int start){
        if(start == arr.length-1 && valid(arr)) {
            res++;
            int[][] present = new int[8][8];
            for (int i = 0; i < arr.length; i++) {
                present[i][arr[i]] = 1;
            }
            for(int i = 0; i < present.length; i++){
                for(int j = 0; j < present.length; j++){
                    System.out.print(present[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        for (int i = start; i < arr.length; i++){
            swap(arr,i,start);
            process(arr,start+1);
            swap(arr,i,start);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean valid(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if(i == j)
                    continue;
                if(Math.abs(i-j) == arr[i] - arr[j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(kinds());
    }

}
