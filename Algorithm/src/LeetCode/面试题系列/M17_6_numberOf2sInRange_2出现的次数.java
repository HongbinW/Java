package LeetCode.面试题系列;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M17_6_numberOf2sInRange_2出现的次数 {
    public int numberOf2sInRange(int n) {
        int bigger = n / 10;
        int smaller = 0;
        int cur = n % 10;
        int base = 1;
        int res = 0;
        while (bigger != 0 || cur != 0){
            if (cur > 2){
                res += (bigger + 1) * base;
            }else if (cur == 2){
                res += bigger * base + smaller + 1;
            }else{
                res += bigger * base;
            }
            smaller += cur * base;
            cur = bigger % 10;
            bigger /= 10;
            base *= 10;
        }
        return res;
    }
}
