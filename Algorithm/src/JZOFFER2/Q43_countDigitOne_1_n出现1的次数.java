package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
public class Q43_countDigitOne_1_n出现1的次数 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(100));
    }
    public static int countDigitOne(int n) {
        int base = 1;
        int res = 0;
        int bigger = n / 10;
        int smaller = 0;
        int cur = n % 10;
        while (bigger != 0 || cur != 0){
            if (cur == 1){
                res += bigger * base + smaller + 1;
            }else if (cur == 0){
                res += bigger * base;
            }else{
                res += (bigger+1) * base;
            }
            smaller += base * cur;      //这种思路更好，可以有效防止base越界的情况
            cur = bigger % 10;
            bigger /= 10;
            base *= 10;
        }
        return res;
    }
}
