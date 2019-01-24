package basic.changyonglei.ExerciseString;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/23
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.模拟一个trim方法，去除字符串两端的空格。
 *
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 *
 * 3.获取一个字符串在另一个字符串中出现的次数。
 *       比如：获取“ ab”在 “abkkcadkabkebfkabkskab”
 *       中出现的次数
 * 4.获取两个字符串中最大相同子串。比如：
 *    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 *    提示：将短的那个串进行长度依次递减的子串与较长
 *    的串比较。
 *
 * 5.对字符串中字符进行自然顺序排序。
 * 提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡，Arrays.sort();
 * 3）将排序后的数组变成字符串。
 *
 * 6.练习： I am a student!  写一个方法，实现输出 !student a am I
 *
 */
public class StringDemo {
    public static void main(String[] args) {
        String str1 = "   a b c d   e f g   ";
        String str2 = "    ";
        StringDemo sd = new StringDemo();
        System.out.println("----" + sd.sitrim(str1) + "----");
        System.out.println("----" + sd.sitrim(str2) + "----");
        String str3 = "abcdefg";
        System.out.println(sd.subreverse(str3,2,5));
        System.out.println(sd.subreverse2(str3,2,5));
        String str4 = "abkkcadkabkebfkabkskab";
        System.out.println(sd.count(str4,"ab"));
        String str5 = "abcwethelloyuiodef";
        String str6 = "abcwecvhellobnm";
        System.out.println(sd.MaxEqualsSubString(str5,str6));
        String str7 = "dslkfjwen";
        System.out.println(sd.NaturalSort(str7));
    }
    //1.模拟一个trim方法，去除字符串两端的空格。
    public String sitrim(String origin){
        if(origin == null)
            return origin;
        int i = 0;
        int j = origin.length() - 1;
        if(origin.startsWith(" ")) {
            while (origin.charAt(i) == ' ' && i < j) {
                i++;
            }
        }
        if(origin.endsWith(" ")){
            while(origin.charAt(j) == ' ' && i < j){
                j--;
            }
        }
        if(i == j)
            return "";
        return origin.substring(i,j + 1);
    }
    //2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
    //法一：
    public String subreverse(String str, int start, int end){
        char[] c = str.toCharArray();  //转为字符数组
        return reverseArray(c,start,end);
    }
    public static String reverseArray(char[] c, int start, int end){
        for(int i = start,j = end; i < j; i++,j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        //字符数组转化为字符串
        return new String(c);
    }
    //法二：   可以再考虑StringBuffer将此算法优化
    public String subreverse2(String str, int start, int end){
        String str1 = str.substring(0,start);
        for(int i = end; i >= start; i--){
            char c = str.charAt(i);
            str1 += c;
        }
        String str2 = str.substring(end + 1);
        return str1 + str2;
    }
    //3.获取一个字符串在另一个字符串中出现的次数。
    // *       比如：获取“ ab”在 “abkkcadkabkebfkabkskab”
    // *       中出现的次数
    public int count(String str, String substr){
        if(!str.contains(substr))
            return 0;
        String temp = str.replace(substr,"");
        System.out.println(temp);
        System.out.println(str);
        return (str.length() - temp.length()) / substr.length();
    }
    //4.获取两个字符串中最大相同子串。比如：
    // *    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
    // *    提示：将短的那个串进行长度依次递减的子串与较长
    // *    的串比较。
    public List<String> MaxEqualsSubString(String str1, String str2){
        String maxString = str1.length() > str2.length() ? str1 : str2;
        String minString = str1.length() > str2.length() ? str2 : str1;
        int len = minString.length();
        List<String> list = new ArrayList<>();    //增加list，当有两个及以上相同长度的相同子串时，会都显示出来
        for(int i = 0; i < len; i++){
            for(int x = 0, y = len - i; y <= len; x++,y++){ //固定长度为0~len-i的框，从左到右挨着个匹配
                String str = minString.substring(x,y);
                if(maxString.contains(str)){
                    list.add(str);
                }
            }
            if(list.size() != 0){   //当在这个框的宽度下，list大小发生改变了，则返回
                return list;
            }
        }
        return null;
    }
    //5.对字符串中字符进行自然顺序排序。
    // * 提示：
    // * 1）字符串变成字符数组。
    // * 2）对数组排序，选择，冒泡，Arrays.sort();
    // * 3）将排序后的数组变成字符串。
    public String NaturalSort(String str){
        char[] c = str.toCharArray();
        for(int i = 0; i < str.length(); i ++){
            for(int j = 0; j < str.length() - i - 1; j++){
                if(c[j] > c[j + 1]){
                    swap(c,j,j+1);
                }
            }
        }
        return new String(c);
    }
    public static void swap(char[] c,int i ,int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
