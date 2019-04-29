package primary.primary5_Hash;

/**
 * @Author: HongbinW
 * @Date: 2019/4/28 22:22
 * @Version 1.0
 * @Description:
 */
public class Code02_BLfilter {
    public static void main(String[] args) {
        int[] arr = new int[1000];  //32 * 1000 bit

        int index = 30000;

        int intIndex = index / 32;  //来自于哪个整数

        int bitIndex = index % 32;  //来自于整数的哪一位

        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));  //将对应桶的对应位描黑

    }
}
