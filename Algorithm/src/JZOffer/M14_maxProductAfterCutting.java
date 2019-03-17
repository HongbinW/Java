package JZOffer;

/**
 * @Author: HongbinW
 * @Date: 2019/3/17 13:48
 * @Version 1.0
 */
public class M14_maxProductAfterCutting {
    //动态规划  f(n) = max[ f(i) * f(n-i) ]
    public int solution1(int length){
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;
        int[] products = new int[length+1];   //第i个元素表示把长度为i的绳子剪成若干段后，各段长度乘积的最大值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        //对于子段长度<=3，则分解不如不分解
        //其实n=4时，也没必要分解，只是题目要求至少剪一刀，所以剪成2*2
        //products[0-3]，对应i>4，剪成子段后，该子段无论是直接保留还是再分段的最大值
        int max = 0;
        for(int i = 4; i <= length; i++){
            max = 0;
            for(int j = 1; j <= i / 2; j++){        //只剪一次的话，最多就是平分
                int product = products[j] * products[i - j];
                if(max < product)
                    max = product;
                products[i] = max;
            }
        }
        return products[length];
    }
}
