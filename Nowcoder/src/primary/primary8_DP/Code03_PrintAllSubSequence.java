package primary.primary8_DP;

/**
 * @Author: HongbinW
 * @Date: 2019/4/30 16:08
 * @Version 1.0
 * @Description:
 */
public class Code03_PrintAllSubSequence {

    public static void printAllSubSequence(char[] str, int i, String res){
        if(i == str.length){
            System.out.println(res);
            return;
        }
        printAllSubSequence(str,i+1,res+str[i]);
        printAllSubSequence(str,i+1,res);
    }

    public static void main(String[] args) {
        printAllSubSequence("abc".toCharArray(),0,"");
    }
}

