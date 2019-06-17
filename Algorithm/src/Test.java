import java.util.ArrayList;
import java.util.HashSet;

public class Test{
    public static void main(String[] args) {
        process(16,0,0,0);
    }

    static HashSet<ArrayList<Integer>> set = new HashSet<>();
    public static void process(int left, int middle, int right ,int time){
        if (left < 0 || middle < 0 || right < 0)
            return;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(left);
        list.add(middle);
        list.add(right);
        if (set.contains(list)){
            return;
        }else{
            set.add(list);
        }
        if (time == 15){
            return;
        }
        if (left > 0){
            int diff1 = 9 - middle;
            process(left - diff1,middle + diff1,right,time+1);
            int diff2 = 7 - right;
            process(left - diff2, middle, right + diff2,time+1);
        }
        if (middle > 0){
            int diff1 = 16 - left;
            int diff2 = 7 - right;
            process(left + diff1,middle-diff1,right,time+1);
            process(left,middle-diff2,right+diff2,time+1);
        }
        if (right > 0){
            int diff1 = 16 - left;
            int diff2 = 9 - middle;
            process(left + diff1, middle, right - diff1,time+1);
            process(left,middle + diff2, right- diff2,time+1);
        }
        set.remove(list);
    }
}