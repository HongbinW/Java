package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/4/11 21:43
 * @Version 1.0
 * @Description:
 */
public class LeetCode06 {
    public String convert(String s, int numRows) {
        if(s == null || s.length() < 2 || numRows == 1)
            return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        //循环的总次数
        int count = s.length() / ( 2 * numRows - 2);
        int curChar = 0;
        while(count >= 0) {
            int i = 0;
            while (i < numRows && curChar < s.length()) {
                sb[i].append(s.charAt(curChar++));
                i++;
            }
            i = i - 2;
            while(i > 0 && curChar < s.length()){
                sb[i].append(s.charAt(curChar++));
                i--;
            }
            count--;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sItem : sb){
            res.append(sItem);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LeetCode06 l = new LeetCode06();
        System.out.println(l.convert("PAYPALISHIRING",3));
    }
}
