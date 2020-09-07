package nowcode.vivo.B_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/1
 */
public class Q3 {
    public static class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            int input[] = parseInts(inputStr.split(" "));
            int output = solution(input);
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

        private static int solution(int[] input) {
            int step = 0;
            int end = 0;
            int max = 0;
            for (int i = 0; i < input.length-1; i ++){
                if (i > max){
                    return -1;
                }
                max = Math.max(max, i + input[i]);
                if (i == end) {
                    step++;
                    end = max;
                }
            }
            return step;
        }

    }
}
