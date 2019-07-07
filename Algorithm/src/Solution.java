import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    static ArrayList<String> res = new ArrayList<>();
    public static ArrayList<String> Permutation(String str) {
        char[] cs = str.toCharArray();
        process(0,cs);
        return res;
    }

    public static void process(int index, char[] cs){
        if (index == cs.length-1) {
            res.add(new String(cs));
        }else {
            for (int i = index; i < cs.length; i++) {
                swap(cs, i, index);
                process(index + 1, cs);
                swap(cs, i, index);
            }
        }
    }

    public static void swap(char[] arr, int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        for(String str : Permutation("abc")){
            System.out.println(str);
        }
    }
}