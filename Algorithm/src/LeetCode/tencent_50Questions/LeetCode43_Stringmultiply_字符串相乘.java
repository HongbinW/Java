package LeetCode.tencent_50Questions;


/**
 * @Author: HongbinW
 * @Date: 2019/9/3 11:24
 * @Version 1.0
 * @Description:
 */
public class LeetCode43_Stringmultiply_字符串相乘 {
    public static String multiply(String num1, String num2) {
        if (num1.length() < num2.length()){
            return multiply(num2,num1);
        }
        int[] chs = new int[num1.length() + num2.length()];
        int c = 0;
        int index = 0;
        for (int i = num2.length() - 1; i >= 0; i --){
            index = num2.length() - i - 1;
            for (int j = num1.length() - 1; j >= 0;j --){
                int temp = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + c + chs[index];
                chs[index++] = (temp % 10);
                c = temp / 10;
            }
            chs[index++] += c;
            c = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = chs.length-1; i >= 0; i --){
            sb.append(chs[i]);
        }
        return sb.toString().charAt(0) == '0' ? sb.toString().substring(1):sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("999","999"));
    }
}
