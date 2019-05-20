package JZOffer.F_abstractToSpecific;

import java.util.ArrayList;

public class M38_Permutation {
    public static ArrayList<String> Permutation(String str) {
        if(str == null){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        char[] chs = str.toCharArray();
        process(chs,0,list);
        return list;
    }

    public static void process(char[] chs,int start,ArrayList<String> list){
        if(start == chs.length - 1){
            list.add(new String(chs));
        }
        for(int i = start; i < chs.length; i++){
            if(i != start && chs[i] == chs[start])
                continue;
            swap(chs,start,i);
            process(chs,start+1,list);
            swap(chs,start,i);
        }
    }
    public static void swap(char[] chs, int i , int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        String str = "ab";
        ArrayList<String> list = Permutation(str);
        for(String ele : list){
            System.out.println(ele);
        }
    }
}
