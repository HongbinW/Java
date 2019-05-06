package examination.HuaWei.huawei_2016_2;

import java.util.Scanner;

public class ThelastOneIndex {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNextInt()){
                int N = sc.nextInt();
                int[] arr = new int[N];
                int count = 0;
                int size = N;
                int i = 0;
                int lastone = 0;
                while(size != 1){
                    if(arr[i] == 1){
                        i++;
                    }
                    if(i == N){
                        i = 0;
                    }
                    if(arr[i] == 0){
                        if(count == 2){
                            arr[i] = 1;
                            size--;
                            count = 0;
                            i++;
                        }else{
                            lastone = i;
                            count ++;
                            i++;
                        }
                    }
                    if(i == N){
                        i = 0;
                    }
                }
                System.out.println(lastone);
        }
    }
}
