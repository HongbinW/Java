import java.util.ArrayList;

public class Test{
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5};

        process(arr);
        System.out.println(arr[0]);
    }
    public static void process(int[] arr){
        arr[0] = 100;
    }
}