package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/10
 */
public class LeetCode551_checkRecord_学生出勤记录I {
    public boolean checkRecord(String s) {
        int A = 0;
        int L = 0;
        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == 'A'){
                A ++;
            }else if (s.charAt(i) == 'L'){
                if (i > 0 && s.charAt(i-1) == 'L'){
                    L ++;
                }else{
                    L = 1;
                }
            }
            if (A > 1){
                return false;
            }
            if (L > 2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode551_checkRecord_学生出勤记录I().checkRecord("LALL"));
    }
}
