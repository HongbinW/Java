package LeetCode.classify.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/15
 */
public class LeetCode119_getRow_杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0){
            return list;
        }
        list.add(1);
        if (rowIndex == 1){
            return list;
        }
        list.add(1);
        for (int i = 2; i <= rowIndex; i ++){
            for (int j = i/2; j > 0; j --){
                int num1 = list.get(j) == 0 ? list.get(j-1) : list.get(j);
                int num2 = list.get(j-1);
                list.set(j,list.get(j) + list.get(j-1));
            }
        }
        for (int i = list.size()-1; i >= list.size()/2; i --){
            list.set(i,list.get(list.size()-1-i));
        }
        return list;
    }
}
