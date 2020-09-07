package examination.大疆;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int K = sc.nextInt();
        System.out.println(process(str,K));
    }
    public static String process(String str, int k){
        while (k >= str.length()){
            return "0";
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] chs = str.toCharArray();
        for (char c : chs){
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > c){
                stack.removeLast();
                k --;
            }
            stack.addLast(c);
        }
        while (k > 0){
            stack.removeLast();
            k --;
        }

        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (char c : stack){
            if (isZero && c == '0'){
                continue;
            }
            isZero = false;
            sb.append(c);
        }
        if (sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }

}