package examination.HuaWei;

import java.util.ArrayList;

/**
 * @Author: HongbinW
 * @Date: 2019/4/27 10:28
 * @Version 1.0
 * @Description:    待验证
 * 判断输入的字符串是否为双对称字符串，是的话输出对应的单对称字符串（aabbaa则输出aba），否则输出false。
 *         双对称字符串：
 *             1、正序逆序相同。
 *             2、偶数个字符.
 *             3、从第一个字符开始每一对字符相同（aabbccbbaa）。
 */
public class E1 {
    public static void printStr(String str){
        if(str == null || str.length() == 0) {
            System.out.println();
            return;
        }
        if(str.length() % 2 == 1) {
            System.out.println("false");
            return;
        }
        int i = 0, j = str.length() -1;
        char[] res = new char[str.length()/2];
        while(i <= j){
            if(str.charAt(i) == str.charAt(j) && str.charAt(i+1) == str.charAt(j-1) && str.charAt(i) == str.charAt(i+1)){
                res[i/2] = str.charAt(i);
                res[j/2] = str.charAt(j);
                i += 2;
                j -= 2;
            }else{
                System.out.println("false");
                break;
            }
        }
        if(i > j)
        System.out.println(res);
    }

    public static void main(String[] args) {
        printStr("aabbccbbaa");
    }
}
