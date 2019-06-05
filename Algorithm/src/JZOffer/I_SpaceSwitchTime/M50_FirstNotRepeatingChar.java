package JZOffer.I_SpaceSwitchTime;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: HongbinW
 * @Date: 2019/6/5 22:57
 * @Version 1.0
 * @Description:
 */
public class M50_FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0 ; i < str.length(); i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),0);
            }
            map.put(str.charAt(i),map.get(str.charAt(i))+1);
        }
        for (int i = 0 ; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }
}
