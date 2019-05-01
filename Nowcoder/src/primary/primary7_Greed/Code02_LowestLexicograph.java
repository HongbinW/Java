package primary.primary7_Greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: HongbinW
 * @Date: 2019/4/30 12:37
 * @Version 1.0
 * @Description:
 */
public class Code02_LowestLexicograph {

    public static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String a,String b){
            return (a+b).compareTo(b+a);
        }
    }

    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        String res = "";
        for(int i = 0; i < strs.length; i++){
            res += strs[i];
        }
        return res;
    }
}
