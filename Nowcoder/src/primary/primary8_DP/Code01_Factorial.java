package primary.primary8_DP;

/**
 * @Author: HongbinW
 * @Date: 2019/4/30 15:11
 * @Version 1.0
 * @Description:
 */
public class Code01_Factorial {

    public static long getFactorial1(int n){
        if(n == 1)
            return 1;
        return (long)n * getFactorial1(n - 1);
    }





}
