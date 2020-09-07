package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/5
 */
public class LeetCode44_isMatch_通配符匹配 {
    public static void main(String[] args) {
        System.out.println(new LeetCode44_isMatch_通配符匹配().isMatch("acdcb","a*c?b"));
    }
    public boolean isMatch(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        return process(chs,chp,0,0);
    }
    public boolean process(char[] chs, char[] chp, int indexS, int indexP){
        if (indexS >= chs.length && indexP >= chp.length){
            return true;
        }else if (indexS < chs.length && indexP == chp.length){
            return false;
        }else{
            if(indexS == chs.length){
                while (indexP < chp.length){
                    if (chp[indexP] != '*'){
                        return false;
                    }
                    indexP++;
                }
                return true;
            }
            else if (chp[indexP] == '*'){
                return process(chs,chp,indexS+1,indexP) || process(chs,chp,indexS+1,indexP+1) || process(chs,chp,indexS,indexP+1);
            }else if (chp[indexP] == chs[indexS] || chp[indexP] == '?'){
                return process(chs,chp,indexS+1,indexP+1);
            }else{
                return false;
            }
        }
    }
}
