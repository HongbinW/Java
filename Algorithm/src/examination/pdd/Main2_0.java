package examination.pdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/2
 */
public class Main2_0 {
    static class Node{
        int[] arr;
        int count = 1;
        Node(int[] arr){
            this.arr = arr;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] data = new int[N][6];
        for (int i = 0; i < N; i ++){
            String[] strs = sc.nextLine().split(" ");
            for (int j = 0; j < strs.length; j ++){
                data[i][j] = Integer.parseInt(strs[j]);
            }
        }

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i ++){
            if (!process(data[i],list)){
                list.add(new Node(addOne(data[i])));
            }
        }
        Collections.sort(list,(o1, o2) -> o2.count - o1.count);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i ++){
            if (i != list.size()-1) {
                System.out.printf("%d ", list.get(i));
            }else{
                System.out.println(list.get(i).count);
            }
        }
    }
    public static int[] addOne(int[] single){
        int[] res = new int[6];
        for (int i = 0; i < single.length; i ++){
            res[i] = single[i];
        }
        return res;
    }
    public static boolean process(int[] arr, ArrayList<Node> list){
        boolean flag = bianli(arr,list);
        if (flag){
            return true;
        }
        swap(arr,0,1);
        swap(arr,4,5);
        return bianli(arr,list);
    }
    public static boolean bianli(int[] arr, ArrayList<Node> list){
        for (int i = 0; i < 4; i ++){
            for (int j = 0; j < list.size(); j ++) {
                if (valid(arr, list.get(j).arr)){
                    list.get(j).count ++;
                    return true;
                }
                int tmp = arr[2];
                arr[2] = arr[5];
                arr[5] = arr[3];
                arr[3] = arr[4];
                arr[4] = tmp;
            }
        }
        return false;
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static boolean valid(int[] arr, int[] data){
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] != data[i]){
                return false;
            }
        }
        return true;
    }
}
