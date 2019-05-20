package typical.arrange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/f9a4c19050fc477e9e27eb75f3bfd49c?tpId=37&tqId=21264&tPage=3&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 牛客在线编程-华为机试-放砝码
 *
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 * 注：
 *
 * 称重重量包括0
 *
 * 方法原型：public static int fama(int n, int[] weight, int[] nums)
 *
 *
 * 输入描述:
 * 输入包含多组测试数据。
 *
 * 对于每组测试数据：
 *
 * 第一行：n --- 砝码数(范围[1,10])
 *
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 *
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述:
 * 利用给定的砝码可以称出的不同的重量数
 *
 * 示例1
 * 输入
 * 2
 * 1 2
 * 2 1
 * 输出
 * 5
 */
public class Q1_PlaceWeights {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            int[] m = new int[N];
            int[] c = new int[N];
            for(int i = 0; i < N; i++){
                m[i] = sc.nextInt();
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                c[i] = sc.nextInt();
            }
            for(int i = 0; i < N; i++){
                while(c[i] > 0){
                    list.add(m[i]);
                    c[i] --;
                }
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(0);
            for(int i = 0; i < list.size(); i++){
                HashSet<Integer> temp = new HashSet<>();
                for(int ele : set){
                    temp.add(ele+list.get(i));
                }
                set.addAll(temp);
            }
            System.out.println(set.size());
        }
    }
}
