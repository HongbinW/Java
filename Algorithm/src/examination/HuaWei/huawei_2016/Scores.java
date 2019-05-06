package examination.HuaWei.huawei_2016;

import java.util.Scanner;

public class Scores {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0 ; i < N; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0 ; i < M; i++){
                String s = sc.next();
                if(s.equals("Q")){
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    if(start > end){
                        int temp = start;
                        start = end;
                        end = temp;
                    }
                    int res = 0;
                    for(int n = start-1; n < end; n++){
                        res = res > arr[n] ? res : arr[n];
                    }
                    System.out.println(res);
                }else if(s.equals("U")){
                    int id = sc.nextInt()-1;
                    int score = sc.nextInt();
                    arr[id] = score;
                }
            }
        }
    }
}
