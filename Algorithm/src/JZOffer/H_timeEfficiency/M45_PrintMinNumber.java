package JZOffer.H_timeEfficiency;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class M45_PrintMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        Integer[] arr = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = numbers[i];
        }
        Arrays.sort(arr,new MyComperator());
        StringBuilder sb = new StringBuilder();
        for (int i : arr){
            sb.append(i);
        }
        return sb.toString();
    }
}

class MyComperator<Integer> implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        String str1 = String.valueOf(o1);
        String str2 = String.valueOf(o2);
        return (str1+str2).compareTo((str2+str1));
    }
}
