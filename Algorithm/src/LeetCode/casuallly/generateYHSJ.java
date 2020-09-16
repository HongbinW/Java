package easy;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/25
 */

//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class generateYHSJ {
//    @Test
    public void test1(){
        System.out.println(generate1(5));
    }
    public List<List<Integer>> generate1(int numRows) {
       List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows < 0){
            return triangle;
        }
        List<Integer> prerow = new ArrayList();
        for(int i = 0; i < numRows; i++){
           List<Integer> row = new ArrayList();
           row.add(0,1);
           if(i > 1) {
               for (int j = 1; j < i; j++) {
                   row.add(prerow.get(j) + prerow.get(j - 1));
               }
           }
           if(i != 0) {
               row.add(1);
           }
            prerow = row;
           triangle.add(row);
       }
       return triangle;
    }
}
