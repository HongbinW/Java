package LeetCode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/9/3
 */
public class LeetCode51_solveNQueens_N皇后 {
    public static void main(String[] args) {
        List<List<String>> res = new LeetCode51_solveNQueens_N皇后().solveNQueens(4);
        for (List<String> list : res){
            for (String str : list){
                System.out.println(str);
            }
            System.out.println();
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1){
            return res;
        }
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            set.add(i);
            arr[0] = i;
            process(res, arr,1, set);
            set.remove(i);
        }
        return res;
    }
    public void process(List<List<String>> res, int[] arr, int start, HashSet<Integer> set){
        if (start == arr.length){
            char[][] chs = new char[arr.length][arr.length];
            for (int i = 0; i < arr.length; i ++){
                if (arr[i] == -1){
                    return;
                }
                Arrays.fill(chs[i],'.');
                chs[i][arr[i]] = 'Q';
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < chs.length; i ++){
                list.add(new String(chs[i]));
            }
            res.add(list);
        }
        for (int i = 0; i < arr.length; i ++){
            if (set.contains(i)){
                continue;
            }
            boolean flag = false;
            for (int j = 0; j < start; j ++){
                if (Math.abs(j - start) == Math.abs(i - arr[j])){
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                arr[start] = i;
                set.add(i);
                process(res, arr, start + 1, set);
                arr[start] = -1;
                set.remove(i);
            }
        }
    }
}
