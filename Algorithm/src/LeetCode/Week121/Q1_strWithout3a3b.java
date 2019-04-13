package LeetCode.Week121;

/**
 * @Author: HongbinW
 * @Date: 2019/4/13 9:41
 * @Version 1.0
 * @Description:
 */
public class Q1_strWithout3a3b {
    public String strWithout3a3b(int A, int B) {
        //charA和countA代表较多的字符
        char charA = A > B ? 'a' : 'b';
        char charB = charA == 'a' ? 'b' : 'a';
        int countA = A > B ? A : B;
        int countB = countA == A ? B: A;
        String res = "";
        int duan = (countA+1)/2;
        int[] count = new int[duan];
        for(int i = 0; i < countB; i++){
            count[i%duan]++;
        }
        //最后一段先不添加，等把多于的charA填完后再添加
        for(int i = 0; i < duan-1; i++){
            res += charA;
            res += charA;
            countA -= 2;
            while(count[i] > 0){
                count[i] --;
                res += charB;
                countB--;
            }
        }
        while(countA > 0){
            res += charA;
            countA--;
        }
        while(countB > 0){
            res += charB;
            countB--;
        }
        return res;
    }

    public static void main(String[] args) {
        Q1_strWithout3a3b q = new Q1_strWithout3a3b();
        System.out.println(q.strWithout3a3b(1,2));
    }
}
