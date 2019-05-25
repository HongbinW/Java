import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.equals(""))
                break;
            int N = Integer.parseInt(str);
            int[] arr = new int[N];
            int i = 0;
            for(; i < N; i++){
                arr[i] = sc.nextInt();
            }
            if(i != N)
                continue;
            int res = Integer.MIN_VALUE;
            i = 0;
            for(; i < N - 1; i++){
                for(int j = i+1; j < N; j++){
                    res = Math.max(res,arr[j]+arr[i]+i-j);
                }
            }
            System.out.println(res);
        }
    }
}