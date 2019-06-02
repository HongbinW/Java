package JZOffer.H_timeEfficiency;

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

    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{1,2,3,4,5}));
    }
}

class MyComperator<Integer> implements Comparator<Integer>{

    public MyComperator(){

    }

    @Override
    public int compare(Integer o1, Integer o2) {
        int i = 0;
        String str1 = o1.toString();
        String str2 = o2.toString();
        while (i < str1.length() && i < str2.length()){
            if (str1.charAt(i) < str2.charAt(i))
                return 1;
            else if (str1.charAt(i) > str2.charAt(i))
                return -1;
            else {
                i++;
            }
        }
        if(i == str1.length()){
            return str2.charAt(i) - str1.charAt(i-1);
        }else{
            return str1.charAt(i) - str2.charAt(i-1);
        }
    }
}
