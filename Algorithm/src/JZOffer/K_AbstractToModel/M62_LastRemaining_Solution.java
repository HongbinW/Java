package JZOffer.K_AbstractToModel;

import java.util.ArrayList;
import java.util.Queue;

public class M62_LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0 ; i < n; i ++){
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1){
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    //法二
    public int LastRemaining(int n, int m){
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i ++){
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new M62_LastRemaining_Solution().LastRemaining_Solution(5,3));
        System.out.println(new M62_LastRemaining_Solution().LastRemaining(5,3));
    }
}
