package JZOffer.C_codeIntegrity;

//考虑的要极其周密

/**
 * @Author: HongbinW
 * @Date: 2019/3/18 15:04
 * @Version 1.0
 */
public class M16_Power {
    public double Power(double base, int exponent){
        if(exponent == 0)
            return 1;
        if(Double.toString(base) == Double.toString(0.0)){
            if(exponent < 0){
                throw new IllegalArgumentException("The Index is illegal.");
            }
            return 0;
        }
        double res = 1.0;
        int expAbs = exponent > 0 ? exponent : 0-exponent;
        while(expAbs > 0){
            res *= base;
            expAbs --;
        }
        return exponent > 0 ? res : 1/res;
    }
    //提高POW运算效率
    public double PowerWithUnsignedExponent(double base,int exponent){
        if(exponent == 1){
            return base;
        }
        if(exponent == 0){
            return 1;
        }
        double res = PowerWithUnsignedExponent(base,exponent >> 1);
        res *= res;
        if((exponent & 0x1) == 1){
            res *= base;
        }
        return res;
    }
}
