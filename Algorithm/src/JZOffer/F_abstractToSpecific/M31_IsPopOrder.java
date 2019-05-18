package JZOffer.F_abstractToSpecific;

import java.util.Stack;

public class M31_IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        int index = 1;
        int order = 0;
        while(order < popA.length){
            if(stack.peek() == popA[order]){
                stack.pop();
                order++;
            }else if(index == pushA.length) {
                break;
            }
            else{
                stack.push(pushA[index++]);
            }
        }
        return index == pushA.length && order == popA.length;
    }
    //类似做法，不用设置那么多变量
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if(pushA.length != popA.length ||
                pushA.length == 0 ||
                popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{5,4,3,2,1}));
    }
}
