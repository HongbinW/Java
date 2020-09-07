package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/5
 */
public class LeetCode415__addStrings_字符串相加 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
            return "0";
        }
        if (num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        StringBuilder sb = new StringBuilder();
        int c = 0, i = 0;
        for (; i < num2.length(); i ++){
            int x = num1.charAt(num1.length() - 1 - i) - '0';
            int y = num2.charAt(num2.length() - 1 - i) - '0';
            int temp = x + y + c;
            sb.append(temp%10);
            c = temp / 10;
        }
        while (i < num1.length()){
            int temp = num1.charAt(num1.length()-1-i) - '0' + c;
            sb.append(temp % 10);
            c = temp / 10;
            i ++;
        }
        if (c != 0)
            sb.append(c);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode415__addStrings_字符串相加().addStrings("1","320"));
    }
}
