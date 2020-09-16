import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ttt{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list= new ArrayList<>();
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(str);
            if (str.equals("")){
                break;
            }
            list.add(str);
        }
        System.out.println(list.size());
    }
    public static void process(int[] arr, int start, int n){
        if (start == n){
            for (int i = 0; i < arr.length; i ++){
                System.out.printf("%d ", arr[i]);
            }
            System.out.println();
            return;
        }
        for(int i = start; i < n; i ++){
            swap(arr,i, start);
            process(arr,i+1, n);
            swap(arr,i, start);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}