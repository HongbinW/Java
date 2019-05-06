package examination.HuaWei.huawei_2016_2;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class NoDupSeq {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for(int i = 0 ;i < s.length(); i++){
                set.add(s.charAt(i));
            }
            for(char c : set){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
