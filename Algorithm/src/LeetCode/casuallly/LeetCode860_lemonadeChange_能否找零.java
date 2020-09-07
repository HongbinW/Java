package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/21
 */
public class LeetCode860_lemonadeChange_能否找零 {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int i = 0; i < bills.length; i ++){
            if (bills[i] == 5){
                count5 ++;
            }else if (bills[i] == 10){
                count10 ++;
                count5 --;
                if (count5 < 0){
                    return false;
                }
            }else{
                if (count10 > 0){
                    count10 --;
                    count5 --;
                }else{
                    count5 -= 3;
                }
                if (count5 < 0 || count10 < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
