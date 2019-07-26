package LeetCode.explore_byteDance.String;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//说明：
//
//num1 和 num2 的长度小于110。
//num1 和 num2 只包含数字 0-9。
//num1 和 num2 均不以零开头，除非是数字 0 本身。
//不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
public class Q4_multiply {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        //用num2的对应位×num1的每一位
        for (int i = ch2.length-1 ; i >= 0; i --){
            for (int j = ch1.length - 1; j >= 0; j --){
                int temp = (ch2[i] - '0') * (ch1[j] - '0') + arr[i + j + 1];
                arr[i + j + 1] = temp % 10;
                arr[i + j] += temp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i ++){
            sb.append(arr[i]);
        }
        return sb.charAt(0) == '0' ? sb.toString().substring(1) : sb.toString();
    }
}
