package examination.浪潮;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/7
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0){
            System.out.println("1 50");
            return;
        }
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i = 0; i < n; i ++){
            int cur = sc.nextInt();
            if ((cur & 1) == 0){
                even.add(cur);
            }else{
                odd.add(cur);
            }
        }
        odd.sort((o1, o2) -> o1-o2);
        even.sort((o1, o2) -> o1-o2);
        if (odd.isEmpty()){
            System.out.println("1 50");
            return;
        }
        if (even.isEmpty()){
            System.out.println("2 50");
            return;
        }
        int index = 1;
        int max = odd.get(0) / 2;
        for (int i = 1; i < odd.size(); i ++){
            if ((odd.get(i) - odd.get(i-1) - 2) / 2 > max){
                max = (odd.get(i) - odd.get(i-1) - 2) / 2;
                index = odd.get(i-1) + 2;
            }
        }
        if ((99 - odd.get(odd.size()-1)) / 2 > max){
            max = (99 - odd.get(odd.size()-1)) / 2;
            index = odd.get(odd.size()-1) + 2;
        }

        if ((even.get(0) - 2) / 2 > max){
            index = 2;
            max = (even.get(0) - 2) / 2;
        }
        for (int i = 1; i < even.size() - 1; i ++){
            if ((even.get(i) - even.get(i-1) - 2) / 2 > max){
                max = (even.get(i) - even.get(i-1) - 2) / 2;
                index = even.get(i-1) + 2;
            }
        }
        if ((100 - even.get(even.size()-1)) / 2 > max){
            max = (100 - even.get(even.size()-1)) / 2;
            index = even.get(even.size()-1) + 2;
        }
        System.out.println(index + " " + max);
    }
}
