package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/23
 */
public class LeetCode67_addBinary_二进制求和 {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()){
            return addBinary(b,a);
        }
        char[] cha = a.toCharArray();
        char[] chb=  b.toCharArray();
        int indexA = cha.length - 1;
        int indexB = chb.length - 1;
        int c = 0;
        while (indexA >= 0 && indexB >= 0){
            int cur = cha[indexA] - '0' + chb[indexB] - '0' + c;
            c = cur / 2;
            cha[indexA] = (char)(cur % 2 + '0');
            indexA --;
            indexB --;
        }
        while (indexA >= 0){
            int cur = cha[indexA] - '0' + c;
            c = cur / 2;
            cha[indexA--] = (char)(cur % 2 + '0');
        }
        return c != 0 ? c + new String(cha) : new String(cha);
    }
}
