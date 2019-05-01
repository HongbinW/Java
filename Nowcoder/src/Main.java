import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String str = sc.next() + "0000000";
            while(str.length() >= 8){
                list.add(str.substring(0,8));
                str = str.substring(8);
            }
        }
        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}