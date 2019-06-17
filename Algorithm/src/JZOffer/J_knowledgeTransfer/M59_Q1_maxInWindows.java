package JZOffer.J_knowledgeTransfer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class M59_Q1_maxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++){
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if (queue.peekFirst() == i - size){ //元素要么因为自己小被清理出去，要么因为过期了被清理出去
                queue.pollFirst();
            }
            if (i >= size - 1){
                list.add(num[queue.peekFirst()]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        M59_Q1_maxInWindows test = new M59_Q1_maxInWindows();
        ArrayList<Integer> list = test.maxInWindows(new int[]{1,2,4,6,3,3,3},3);
        for (int i : list){
            System.out.print(i + " ");
        }
    }
}
