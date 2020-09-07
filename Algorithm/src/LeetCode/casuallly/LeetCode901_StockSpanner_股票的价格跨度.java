package LeetCode.casuallly;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/17
 */
public class LeetCode901_StockSpanner_股票的价格跨度 {
    public static void main(String[] args) {
        StockSpanner S = new LeetCode901_StockSpanner_股票的价格跨度().new StockSpanner();
        System.out.println(S.next(100));
        System.out.println(S.next(80));
        System.out.println(S.next(60));
        System.out.println(S.next(70));
        System.out.println(S.next(60));
        System.out.println(S.next(75));
        System.out.println(S.next(85));

    }
    class StockSpanner {

        ArrayList<Integer> data;
        ArrayList<Integer> index;
        int size;
        public StockSpanner() {
            data = new ArrayList<>();
            index = new ArrayList<>();
            size = 0;
        }

        public int next(int price) {
            if (size == 0){
                data.add(price);
                index.add(1);
                size ++;
                return 1;
            }
            int pre = size - 1;
            int res = 1;
            while (pre >= 0 && data.get(pre) <= price){
                res += index.get(pre);
                pre -= index.get(pre);
            }
            data.add(price);
            index.add(res);
            size ++;
            return res;
        }
    }
}
