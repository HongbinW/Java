package JZOffer.C_codeIntegrity;

/**
 * @Author: HongbinW
 * @Date: 2019/4/3 10:29
 * @Version 1.0
 * @Description:
 */
public class isNumeric {
    static int index = 0;
    public static boolean isNumeric(char[] str) {
        if(str == null)
            return false;
        boolean numeric = scanInteger(str);
        if(str[index] == '.'){
            index ++;
            numeric = scanUnsignedInteger(str) || numeric;
        }
        if(str[index] == 'e' || str[index] == 'E'){
            index ++;
            numeric = scanInteger(str) && numeric;
        }
        return numeric && index == str.length;
    }

    private static boolean scanInteger(char[] str){
        if(index < str.length &&(str[index]  == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);
    }
    private static boolean scanUnsignedInteger(char[] str){
        int i = index;
        while(index < str.length &&str[index] >= '1' && str[index] <= '9')
            index++;
        return i < index;   //判断是否有0-9的整数
    }

    public static void main(String[] args) {
        char[] c = ("3.1416E+5").toCharArray();
        System.out.println(isNumeric(c));
    }
}
