package primary.primary8_DP;

/**
 * @Author: HongbinW
 * @Date: 2019/4/30 15:13
 * @Version 1.0
 * @Description:
 */
public class Code02_Hanoi {

    // N : 1 ~ N    表示from上从1~N的问题
    public static void process(int N, String from, String to, String help){
        if(N == 1)
            System.out.println("Move 1 from " + from + " to " + to);
        else{
            process(N-1,from,help,to);  //将1~N-1从from挪到help上去
            System.out.println("Move "  + N + " from " + from + " to " + to);
            process(N-1,help,to,from);  //将1~N-1从help挪到to上去
        }
    }



    public static void main(String[] args) {
        process(3,"左","右","中");
    }
}
