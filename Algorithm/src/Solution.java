import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int N = Integer.parseInt(sc.nextLine());
            String[] strs = new String[N];
            for (int i = 0 ; i < N; i ++){
                strs[i] = sc.nextLine();
            }
            process(strs);
        }
    }
    private static void process(String[] strs){
        String[] res = new String[strs.length];
        for (int i = 0 ;i < strs.length; i ++){
            Stack<Character> stack = new Stack<>();
            char[] chs = strs[i].toCharArray();
            int j = 0;
            while (j < chs.length){
                while (j < chs.length && (chs[j] < '0' || chs[j] > '9')){
                    stack.push(chs[j]);
                    j++;
                }
                if (j == chs.length){
                    break;
                }
                int times = 0;
                StringBuilder t = new StringBuilder();
                while (j < chs.length && chs[j] >= '0' && chs[j] <= '9'){
                    t.append(chs[j]);
                    j++;
                }
                times = Integer.parseInt(t.reverse().toString());
                String str = "";
                if (!stack.isEmpty() && stack.peek() == ')'){
                    stack.pop();
                    while (stack.peek() != '('){
                        str += stack.pop();
                    }
                    stack.pop();
                }else{
                    str += stack.pop();
                }
                while (times > 0){
                    for (int m = str.length()-1; m >= 0; m --){
                        stack.push(str.charAt(m));
                    }
                    times--;
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
/*
5
A11B
(AA)2A
((A2B)2)2g
(YUANFUDAO)2JIAYOU
A2BC4D2
 */