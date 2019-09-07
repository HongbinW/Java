package examination.tencent.nowcoder2016;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: HongbinW
 * @Date: 2019/9/6 20:40
 * @Version 1.0
 * @Description:
 */
public class Main {
    public String[] getGray(int n) {
        String[] res = new String[(1<<n)];
        for (int i = 0 ; i < 1 << n; i ++){
            String cur = Integer.toBinaryString(i ^ (i >> 1));
            int diff = n - cur.length();
            StringBuilder sb = new StringBuilder();
            while (diff > 0){
                sb.append("0");
            }
            res[i] = sb.toString() + cur;
        }
        return res;
    }

}
