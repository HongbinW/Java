package primary.primary8_DP;

/**
 * @Author: HongbinW
 * @Date: 2019/4/30 20:06
 * @Version 1.0
 * @Description:
 */
public class Code06_SumToAim {

    public static boolean isSum(int[] arr,int curSum,int i,int value){
        if(curSum == value)
            return true;
        if(i == arr.length)
            return false;
        return isSum(arr,curSum+arr[i],i+1,value) || isSum(arr,curSum,i+1,value);
    }

}
