package JZOffer.H_timeEfficiency;
public class M43_NumberOf1Between1AndN {
    //法一：
    public static int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++){
            res += process(i);
        }
        return res;
    }
    public static int process(int n){
        int count = 0;
        while (n != 0){
            if(n % 10 == 1)
                count++;
            n /= 10;
        }
        return count;
    }

    //法二：
    /*
    设N = abcde ,其中abcde分别为十进制中各位上的数字。
    如果要计算百位上1出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（高位）的数字。
    ① 如果百位上数字为0，百位上可能出现1的次数由更高位决定。比如：12013，则可以知道百位出现1的情况可能是：
    100~199，1100~1199,2100~2199，，…，11100~11199，一共1200个。可以看出是由更高位数字（12）决定，
    并且等于更高位数字（12）乘以 当前位数（100）。
    ② 如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。比如：12113，则可以知道百位受
    高位影响出现的情况是：100~199，1100~1199,2100~2199，，….，11100~11199，一共1200个。和上面情况
    一样，并且等于更高位数字（12）乘以 当前位数（100）。但同时它还受低位影响，百位出现1的情况是：12100~12113,
    一共114个，等于低位数字（113）+1。
    ③ 如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定，比如12213，则百位出现1的情况是：100~199,
    1100~1199，2100~2199，…，11100~11199,12100~12199,一共有1300个，并且等于更高位数字+1（12+1）乘以当
    前位数（100）。
     */
    public static int NumberOf1Between1AndN_Solution2(int n) {
       //Q43_countDigitOne_1_n出现1的次数
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution2(11));
    }
}
