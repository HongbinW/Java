package primary;

/**
 * Description
 * Author  HongbinW
 * Date 2019/2/13
 */

/**
 * 用数组结构实现大小固定的队列和栈
 */
public class Code11_Array_To_Stack_Queue {
    public static class ArrayStack{
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize){
            if(initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;
        }
        public Integer peek(){
            if(index == 0){
                return null;
            }
            return arr[index - 1];  //返回栈顶元素但是不弹出
        }
        public void push(int value){
            if(index == arr.length){
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[index++] = value;
        }
        public Integer pop(){
            if(index == 0){
                return null;
            }
            return arr[--index];
        }
    }

    public class ArrayQueue{
        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        public ArrayQueue(int initSize){
            if(initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        public Integer peek(){
            if(size == 0){
                return null;
            }
            return arr[start];
        }
        public void push(int value){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[end] = value;
            end = end == arr.length - 1 ? 0 : end + 1;
            size ++;
        }
        public Integer pull(){
            if(size == 0) {
                return null;
            }
            size --;
            int temp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[temp];
        }
    }
}
