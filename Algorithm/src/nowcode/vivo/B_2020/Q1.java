package nowcode.vivo.B_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/1
 */
public class Q1 {

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
        int start = 0;
        if (input.length % 2 != 0){
            input[1] += input[0];
            Arrays.sort(input,1,input.length);
            start = 1;
        }else{
            Arrays.sort(input);
        }
        return process(input,start);
    }

    private static int process(int[] input, int start){
        int left = start, right = input.length-1;
        int wl = 0, wr = 0;
        if ((right+1 - left) / 2 % 2 == 1){
            while (left+1 < right) {
                if (left % 2 == 0) {
                    wl += input[left++] + input[right--];
                } else {
                    wr += input[left++] + input[right--];
                }
            }
            wl += input[left];
            wr += input[right];
        }else{
            while (left < right){
                if (left % 2 == 0) {
                    wl += input[left++] + input[right--];
                } else {
                    wr += input[left++] + input[right--];
                }
            }
        }
        return Math.abs(wl - wr);
    }
}
