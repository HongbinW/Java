package nowcode.vivo.B_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/1
 */
public class Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        int len = input[0];
        int k = input[1];
        int[] arr = new int[len];
        int count = 1;
        int index = 0;
        int num = 0;
        while (count <= len){
            if (arr[index%len] == 0){
                num ++;
                if (num % k == 0){
                    arr[index%len] = count++;
                }
            }
            index ++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i ++){
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[len-1]);
        return sb.toString();
    }
}
