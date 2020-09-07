package examination.alibaba.herbie;
/*
求n个随机数中最小值的期望值

三行输入，分别为：

n: 随机数的个数
l1, l2, ... ln : li 为第i个随机数的最小值
r1, r2, ... rn ：ri 为第i个随机数的最大值
即第i个随机数的取值区间是 [li, ri]，取到区间里数字的概率相等

输出为随机数最小值的期望

还有一些关于浮点数的要求（记不清楚了）

示例：
输入：
2
1 2
3 3

输出

1.83333

解释：

最小值为1：（1，2）（1，3）：概率为2/6

最小值为2：（2，2）（2，3）（3，2）：概率为3/6

最小值为3：（3，3）：概率为1/6

结果为：1*(2/6) + 2*(3/6) + 3*(1/6) = 1.83333
 */
public class qiwang {
    public static void main(String[] args) {
        System.out.println(pcal_e(2,new int[]{1,2},new int[]{3,3}));
    }
    public static double calp(int index,int[] l,int[] r) {     //所有区间都大于等于index，则最小值才是index
        //计算所有区间都大于等于index的概率
        double pi = 1;
        for(int i = 0; i < l.length; i ++) {
            double lennums = r[i] - l[i] + 1;
            if (r[i] < index) {
                return 0;
            } else if (index < l[i]) {
                continue;
            } else {
                double temp = (r[i] - index + 1) / lennums;
                pi *= temp;
            }
        }
        return pi;
    }

    public static double cal_index_p(int index,int[] l,int[] r) {
        //计算index为最小值的概率
        return (calp(index, l, r) - calp(index + 1, l, r));     // P(>=index) - P(>=index+1) = P(index)
    }

    public static double pcal_e (int n, int[] l, int[] r){
        int min_num = min(l);
        int max_num = max(r);
        double res = 0;
        for(int i = min_num; i <= max_num; i ++) {
            res += cal_index_p(i, l, r) * i;
        }
        return res;
    }
    public static int min(int[] arr){
        int res = arr[0];
        for (int i = 1; i < arr.length; i ++){
            if (res > arr[i]){
                res = arr[i];
            }
        }
        return res;
    }
    public static int max(int[] arr){
        int res = arr[0];
        for (int i = 1; i < arr.length; i ++){
            if (res < arr[i]){
                res = arr[i];
            }
        }
        return res;
    }
}
