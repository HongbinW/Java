package JZOffer.G_simplifyQ;

import java.util.ArrayList;

/**
 * 依然输入三个字符a、b、c，求字符的所有组合。
 * a、b、c、ab、ac、bc、abc
 */
public class M38_Exp_Arrange {

    public static ArrayList<String> arrange(String str){
        char[] chs = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        process(chs,res,0,"");
        return res;
    }
    public static void process(char[] chs,ArrayList<String> res, int start,String str){
        if(start == chs.length){
            res.add(str);
            return;
        }
        process(chs,res,start+1,str);
        process(chs,res,start+1,str+chs[start]);
    }

    public static void main(String[] args) {
        ArrayList<String> res = arrange("abc");
        for(String ele : res){
            System.out.println(ele);
        }
    }
}
