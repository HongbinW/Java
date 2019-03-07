package questions;

/*
A = 1 ;  B = 2 ..... Z = 26
随机给一组数，返回可以实现这组数编译成密码的方法数
 */

/*
给出一组数据，返回其中出现次数超过1/3的数据，考虑时间复杂度
 */
public class test {
    public static void main(String[] args) {
        System.out.println(answers("123"));
    }
    public static int answers(String str) {
        if(str.charAt(0) == '0'){
            return 0;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                if(str.charAt(i - 1) > 2){
                    return 0;
                }
                end = i - 1;
                count += countSum(end - start);
                start = i + 1;
                end = i + 1;
            }
            end = i;
        }
        count += countSum(end - start + 1);
        return count;
    }
    public static int countSum(int target){
        int i = 1;
        int j = 2;
        int sum = 0;
        if(target == 1){
            return 1;
        }
        if(target ==2){
            return 2;
        }
        while(target >= 3){
            sum = i + j;
            i = j;
            j = sum;
            target--;
        }
        return sum;
    }
}
