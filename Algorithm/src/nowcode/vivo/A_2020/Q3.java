package nowcode.vivo.A_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/2
 */
public class Q3 {
    public static class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            int output = solution(inputStr );
            System.out.println(output);
        }

        private static int solution(String str) {
            char[] chs = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            int i = 0;
            for (; i < chs.length; i ++){
                if (chs[i] == ')' && !stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    continue;
                }
                if (chs[i] == '0'){
                    break;
                }
                if (chs[i] == '(')
                    stack.push(chs[i]);
            }
            return stack.size();
        }
    }
}
