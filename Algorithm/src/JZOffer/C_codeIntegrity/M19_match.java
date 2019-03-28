package JZOffer.C_codeIntegrity;

/**
 * @Author: HongbinW
 * @Date: 2019/3/27 10:42
 * @Version 1.0
 * @Description:
 */
public class M19_match {
    public static boolean match(String str,String pattern){
        if(str == null && pattern != null || str != null && pattern == null)
            return false;
        int pstr = 0;
        int ppattern = 0;
        while(pstr < str.length() && ppattern < pattern.length()){
            if(pattern.charAt(ppattern) == '.'){
                pstr++;
                ppattern++;
            }else if(pattern.charAt(ppattern) == '*'){  //如果检测到了*，说明前面都是匹配的，所以只需要看str中有多少个*前的那个字符就好
                while(str.charAt(pstr) == pattern.charAt(ppattern-1)){
                    pstr++;
                }
                ppattern++;
            }else if(pattern.charAt(ppattern) == str.charAt(pstr)){
                pstr++;
                ppattern++;
            }else{
                if(ppattern + 1 < pattern.length() && pattern.charAt(ppattern+1) == '*'){
                    ppattern++;
                }else{
                    return false;
                }
            }
        }
        if(pstr == str.length() && ppattern == pattern.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("aaa","ab*a"));
    }
}
