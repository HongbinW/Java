package advance.advance_2;

import java.util.LinkedList;

public class Code01_getMaxWindow {
    public static int[] getMaxWindow(int[] arr, int w){
        if(arr == null || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();  //标准双向链表
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);    //存索引
            if(qmax.peekFirst() == i - w){  //过期了   i超过w后，每次加一个减一个
                qmax.pollFirst();
            }
            if(i >= w - 1){     //从w-1开始，每次取一个窗口的最大值
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = getMaxWindow(new int[]{1,2,4,6,3,3,3},3);
        for (int i = 0 ; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
