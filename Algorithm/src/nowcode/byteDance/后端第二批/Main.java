package nowcode.byteDance.后端第二批;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/2
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i ++){
            arr[i] = sc.nextInt();
            if (map.containsKey(arr[i])){
                map.get(arr[i]).add(i+1);
            }else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i+1);
                map.put(arr[i],tmp);
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i ++){
            int[] query = new int[3];
            for (int j = 0; j < 3; j ++){
                query[j] = sc.nextInt();
            }
            if (!map.containsKey(query[2])){
                System.out.println(0);
                continue;
            }
            List<Integer> tmp = map.get(query[2]);
            int c = 0;
            for (int k = 0; k < tmp.size(); k ++){
                if (tmp.get(k) >= query[0] && tmp.get(k) <= query[1]){
                    c ++;
                }
            }
            System.out.println(c);
        }
    }
}
