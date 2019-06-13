package JZOffer.I_SpaceSwitchTime;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @Author: HongbinW
 * @Date: 2019/6/6 10:34
 * @Version 1.0
 * @Description:
 */
public class M50_Relate2_deleteRepulicateCharacter {
    public static void deleteRepulicateCharacter(String str){
        HashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0 ; i < str.length(); i++){
            set.add(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char i : set){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        deleteRepulicateCharacter("google");
    }
}
