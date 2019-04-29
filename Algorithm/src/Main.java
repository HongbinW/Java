import java.util.HashSet;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        System.out.println(mostLenDulStr("abcbca"));
    }

    public static boolean mostLenDulStr(String str){
        int i = 0, j = 1,cur = 0;
        int count = 0;
        while(cur < str.length() && i < str.length() && j < str.length()){
            while(str.charAt(i) == str.charAt(j)){
                count++;
                i++;
                j++;
                if(count > 2)
                    return false;
            }
            if(str.charAt(i) != str.charAt(j))
                count = 0;
            i++;
            if(i == str.length()-1){
                cur ++;
                i = cur;
                j = i + 1;
                count = 0;
            }
        }
        return true;
    }
}