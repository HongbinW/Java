package nowcode.vivo.春季2020;

/**
 * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）
 * 之乘积等于n，若不存在则输出 -1。
 */

// 我的思路：因为要确定每一位的值，因此可将原数因式分解。可分解2,3,5,7。然后用分解的数去凑出比当前值大的最小值。
// 难点：去凑比当前值大的最小值。相同位数和不同位数，难以实现。

// 题解：从9->2挨着个去尽可能地除n，这样大数肯定在最后，小数肯定在最前。且这种除肯定比除以10慢，所以得到的数肯定比当前值大
// 很巧妙，也省略了按照我因式分解去合并的过程了。
public class Main2_每一位的积为n且比n大的最小整数 {
    public static int solution(int n){
        // 如果小于10
        if (n < 10)
            return 10 + n;
        int res = 0, base = 1;
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {    //9->2都尽可能地去除，这样大的数都在最后，并通过base来调整当前的位数
                res += i * base;
                base*=10;
                n /= i;
            }
        }
        if (n > 1) return -1;
        else return res;
    }
}


//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//// Q2
//public class Main2_每一位的积为n且比n大的最小整数 {
////    public static void main(String[] args) {
////        System.out.println(new Main2_每一位的积为n且比n大的最小整数().solution(362880));
////    }
////    public int solution(int n){
////        ArrayList<Integer> ori = new ArrayList<>();
////        int tmp = n;
////        while (tmp > 0){
////            ori.add(tmp%10);
////            tmp /= 10;
////        }
////        ArrayList<Integer> list = process(n);
////        if (list == null){
////            return -1;
////        }
////        ArrayList<Integer> resList = new ArrayList<>();
////        int index = 0;
////        while (index < list.size()){
////            int cur = 1;
////            while (cur < 10 && index < list.size()){
////                cur *= list.get(index++);
////            }
////            resList.add(cur);
////        }
////        if (resList.size() > ori.size()) {
////            resList.sort(((o1, o2) -> o1 - o2));
////        }else{
////            return plan2(n);
////        }
////        int res = 0;
////        for (int i = 0; i < resList.size(); i ++){
////            res = res * 10 + resList.get(i);
////        }
////        return res;
////    }
//    public int plan2(int n){
//        ArrayList<Integer> list = process(n);
//        if (list == null){
//            return -1;
//        }
//
//        int index = 0;
//        boolean flag = true;
//        int realRes = Integer.MAX_VALUE;
//        int res = 1;
//        int preRes = 0;
//        while (flag) {
//            res *= list.get(index++);
//            if (res > 10){
//                break;
//            }
//            ArrayList<Integer> resList = new ArrayList<>();
//            cal(list, index, list.size() - 1, resList);
//            resList.add(res);
//            if (res * list.get(index) >= 10){
//                flag = false;
//            }
//            preRes = res;
//            res = 0;
//            for (int i = resList.size() - 1; i >= 0; i--) {
//                res = resList.get(i) + res * 10;
//            }
//            realRes = Math.min(realRes,res);
//            res = preRes;
//        }
//        return realRes;
//    }
//    public static void cal(ArrayList<Integer> list, int start, int end, ArrayList<Integer> resList){
//        if (start > end){
//            return;
//        }
//        int cur = 1;
//        while (start <= end && cur < 10){
//            cur *= list.get(end --);
//        }
//        if (cur >= 10){
//            cur /= list.get(++end);
//        }
//        resList.add(cur);
//        cal(list,start,end, resList);
//    }
//
//    public static ArrayList<Integer> process(int target){
//        ArrayList<Integer> list = new ArrayList<>();
//        while (target > 1){
//            if (target % 2 == 0){
//                list.add(2);
//                target /= 2;
//            }else if (target % 3 == 0){
//                list.add(3);
//                target /= 3;
//            }else if (target % 5 == 0){
//                list.add(5);
//                target /= 5;
//            }else if (target % 7 == 0){
//                list.add(7);
//                target /= 7;
//            }else{
//                return null;
//            }
//        }
//        return list;
//    }
//}
