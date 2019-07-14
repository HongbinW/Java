package JZOffer;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0 ; i < numbers.length; i ++){
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs,new MyComparator());
        StringBuilder sb = new StringBuilder();
        for(String i : strs){
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().PrintMinNumber(new int[]{3,5,1,4,2}));
    }
}

class MyComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return (o1 + o2).compareTo(o2 + o1);
    }
}