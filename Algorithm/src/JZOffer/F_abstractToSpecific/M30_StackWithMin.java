package JZOffer.F_abstractToSpecific;

import java.util.Stack;

public class M30_StackWithMin {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> mindata = new Stack<>();
    public void push(int value){
        data.push(value);
        if(mindata.isEmpty()){
            mindata.push(value);
        }
        else if (mindata.peek() >= value){
            mindata.push(value);
        }else{
            mindata.push(mindata.peek());
        }
    }

    public int pop(){
        if(data.isEmpty()){
            throw new RuntimeException("The stack is empty");
        }else{
            mindata.pop();
            return data.pop();
        }
    }
    public int min(){
        return mindata.peek();
    }
}
