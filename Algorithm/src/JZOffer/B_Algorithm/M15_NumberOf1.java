package JZOffer.B_Algorithm;

/**
 * @Author: HongbinW
 * @Date: 2019/3/18 11:21
 * @Version 1.0
 */
public class M15_NumberOf1 {
    public static int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            ++count;
            n = (n - 1) & n;            //秀！ n&(n-1)会将其最右边的一个1变成0，而这个1右边的所有位会化成0,这样有几个1，则会循环几次，从这个1开始往后全变为0
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(9));
    }
}
