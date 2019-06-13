package JZOffer.I_SpaceSwitchTime;

/**
 * @Author: HongbinW
 * @Date: 2019/6/6 10:25
 * @Version 1.0
 * @Description:
 */
public class M50_Relate1_deleteStr1ReferStr2 {
    public static void deleteStr1ReferStr2(String str1, String str2){
        for (int i = 0 ;i < str2.length(); i ++){
            str1 =  str1.replace(str2.charAt(i)+"","");     //替换掉的字符生成了新的字符串
        }
        System.out.println(str1);
    }

    public static void main(String[] args) {
        String str1 = "We are students";
        String str2 = "aeiou";
        deleteStr1ReferStr2(str1,str2);
    }
}
