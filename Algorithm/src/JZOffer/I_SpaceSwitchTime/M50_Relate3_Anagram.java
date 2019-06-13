package JZOffer.I_SpaceSwitchTime;

/**
 * @Author: HongbinW
 * @Date: 2019/6/6 10:41
 * @Version 1.0
 * @Description:
 */
public class M50_Relate3_Anagram {
    public static boolean Anagram(String str1, String str2){
        int[] arr = new int[26];
        if (str1 == null || str2 == null || str1.equals(str2) || str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); i++){
            arr[str1.charAt(i)-'a']++;
        }
        for (int i = 0 ; i < str2.length(); i++){
            if (arr[str2.charAt(i)-'a'] == 0)
                return false;
            arr[str2.charAt(i)-'a']--;
        }
        for (int i = 0 ; i < 26; i++){
            if (arr[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Anagram("listen","silent"));
    }
}
