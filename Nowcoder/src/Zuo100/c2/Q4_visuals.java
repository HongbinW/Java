package Zuo100.c2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/7/31 20:32
 * @Version 1.0
 * @Description:
 */
public class Q4_visuals {
    public static long guardWork(int[] m){      //注意返回是long类型
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();     //此处也可以不用Map，而定义一种数据结构，里面有俩值：数组值、出现的次数
        int indexMax = 0;   //找到最大值的索引
        long res = 0;
        for (int i = 0; i < m.length; i ++){
            indexMax = m[i] > m[indexMax] ? i : indexMax;
        }
        int i = indexMax;
        while (i == indexMax || i % m.length != indexMax){
            int index = i % m.length;
            if (stack.isEmpty() || stack.peek() > m[index]) {   //栈为空，则直接压入元素
                stack.push(m[index]);
                map.put(m[index], 1);
            }else if (stack.peek() < m[index]){     //当前元素比栈顶元素大，则弹栈，弹出后，不直接压入，重新比较当前值与新的栈顶元素
                int temp = stack.pop();
                res += Cni(map.get(temp),2) + 2 * map.get(temp);
                map.remove(temp);
                continue;
            }else{      //栈顶元素与当前元素相等，则直接增加出现次数
                map.put(m[index],map.get(m[index]) + 1);
            }
            /**
             * 下面的循环方法同理
             */
//            while (!stack.isEmpty() && stack.peek() < m[index]) {
//                int temp  = stack.pop();
//                int times = map.get(temp);
//                map.remove(temp);
////				res += getInternalSum(times) + times;
////				res += stack.isEmpty() ? 0 : times;
//                res += Cni(times,2) + times*2;
//            }
//            if (!stack.isEmpty() && stack.peek() == m[index]) {
//                map.put(m[index],map.get(stack.peek())+1);
//            } else {
//                stack.push(m[index]);
//                map.put(m[index],1);
//            }
            i ++;
        }
        int co = map.get(m[indexMax]) != 1 ? 2 : 1;
        while (stack.size() > 1){
            int temp = stack.pop();
            if (stack.size() > 1){
                res += Cni(map.get(temp),2) + 2 * map.get(temp);
            }else {
                res += Cni(map.get(temp), 2) + co * map.get(temp);
            }
        }
        return res + Cni(map.get(m[indexMax]),2);
    }

    //求排列组合Cni,此处只用求Cn2，因此实际只需要计算n(n-1)/2即可
    private static long Cni(int c,int i){
//        if (c == 1){
//            return 0;
//        }
//        int fenzi = 1, fenmu = 1;
//        while (i > 0){
//            fenzi *= (c--);
//            fenmu *= (i--);
//        }
//        return fenzi/fenmu;
        if (c == 1L){
            return 0;
        }else{
            return (long)c * (long)(c-1) / 2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(guardWork(arr));
        }
        int[] arr = new int[]{1000,1000,1000,1000,1000};
        System.out.println(guardWork(arr));
    }

}
