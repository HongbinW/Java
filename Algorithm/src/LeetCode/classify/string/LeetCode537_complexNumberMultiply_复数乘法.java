package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/8
 */
public class LeetCode537_complexNumberMultiply_复数乘法 {
    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        int aR = Integer.parseInt(as[0]);
        int aW = Integer.parseInt(as[1].substring(0,as[1].length()-1));
        int bR = Integer.parseInt(bs[0]);
        int bW = Integer.parseInt(bs[1].substring(0,bs[1].length()-1));
        int rR = aR * bR - aW * bW;
        int rW = aR * bW + aW * bR;
        return rR + "+" + rW + "i";
    }

    public static void main(String[] args) {
        String s = "1+1i";
        String s2 = "1+1i";
        System.out.println(new LeetCode537_complexNumberMultiply_复数乘法().complexNumberMultiply(s,s2));
    }
}
