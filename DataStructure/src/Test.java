import java.util.ArrayList;
import java.util.Stack;

/**
 * 给定指定字符串，只有成对的"<>"才算有效长度，"<<<>"算是长度为2，"<><>><<<>>>"算是长度6，写一个能解决这个问题的代码
 */

public class Test{
    public static int count(String str){
        int nums = 0;
        for(int i = 1; i < str.length(); i ++){
            if(str.charAt(i) == '>' && str.charAt(i - 1) == '<'){
                nums ++;
            }
        }
        return nums * 2;
    }

    public static void main(String[] args) {
        System.out.println(count("><<>>><><>><>>>><<><><>"));
    }
}