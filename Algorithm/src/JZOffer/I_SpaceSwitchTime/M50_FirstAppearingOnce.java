package JZOffer.I_SpaceSwitchTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @Author: HongbinW
 * @Date: 2019/6/6 10:49
 * @Version 1.0
 * @Description:
 */
public class M50_FirstAppearingOnce {
    static HashSet<Character> setInput = new HashSet<>();
    static ArrayList<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        if(setInput.contains(ch) && list.contains(ch)){
            list.remove((Character)ch);
        }else {
            setInput.add(ch);
            list.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        return list.size() == 0 ? '#' : list.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Insert(sc.next().charAt(0));
            System.out.println(FirstAppearingOnce());
        }
    }
}
