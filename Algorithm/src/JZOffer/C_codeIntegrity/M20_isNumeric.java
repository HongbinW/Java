package JZOffer.C_codeIntegrity;

import java.util.LinkedList;
import java.util.Queue;

public class M20_isNumeric {
    public static boolean isNumeric(String str){
        if(str == null || str.length() == 0)
            return false;
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            queue.offer(str.charAt(i));
        }
        boolean numeric = scanInteger(queue);
        if(queue.size() != 0 && ((LinkedList<Character>) queue).peekFirst() == '.'){
            queue.poll();
            numeric = scanUnsignedInteger(queue) || numeric;
        }
        if(queue.size() != 0 && (((LinkedList<Character>) queue).peekFirst() == 'e' || ((LinkedList<Character>) queue).peekFirst() == 'E')){
            queue.poll();
            numeric = scanInteger(queue) && numeric;
        }
        return numeric && queue.size() == 0;
    }

    public static boolean scanInteger(Queue<Character> queue){
        if(queue.size() != 0 && ( queue.peek() == '+' || queue.peek() == '-'))
            queue.poll();
        return scanUnsignedInteger(queue);
    }
    public static boolean scanUnsignedInteger(Queue<Character> queue){
        int size = queue.size();
        while(queue.size() != 0 && queue.peek() >= '0' && queue.peek() <= '9')
            queue.poll();
        return queue.size() < size;
    }

    public static boolean isNumeric2(String str) {
        //return s.matches("[+-]?[0-9]*(.[0-9]*)?([eE][+-]?[0-9]+)?");
        return str.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    public static void main(String[] args) {
        String str = "e1";
        System.out.println(isNumeric(str));
        System.out.println(isNumeric2(str));
    }
}
