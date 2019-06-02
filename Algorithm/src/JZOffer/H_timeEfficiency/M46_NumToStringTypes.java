package JZOffer.H_timeEfficiency;
//没有OJ!

public class M46_NumToStringTypes {
    static int res = 0;
    public static int NumToStringTypes(int number){
        process(number+"",0);
        return res;
    }
    public static void process(String str, int start){
        if (start == str.length()){
            res ++;
            return;
        }
        process(str,start+1);
        if (start + 1 < str.length()){
            int temp = Integer.parseInt(""+str.charAt(start) + str.charAt(start+1));
            if (temp <= 25 && temp >= 10){
                process(str,start+2);
            }
        }
    }

    //法二：从后往前数，这样减少了重复计算
    //dp: f(i) = f(i+1) + g(i,i+1) * f(i+2)
    //其中g(i,i+1)为当i和i+1组成的值在10~25之间时，值为1
    public static int method2(int number){
        String str = String.valueOf(number);
        int[] dp = new int[str.length()+1];
        dp[str.length()] = 1;
        int flag = 0;
        for (int i = str.length()-1; i >= 0; i--){
            if (i+1 < str.length()){
                int temp = Integer.parseInt(""+str.charAt(i) + str.charAt(i+1));
                if (temp >= 10 && temp <= 25){
                    flag = 1;
                }
                dp[i] = dp[i+1] + flag * dp[i+2];
                flag = 0;
            }else{
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(NumToStringTypes(12058));
        System.out.println(method2(12058));
    }
}
