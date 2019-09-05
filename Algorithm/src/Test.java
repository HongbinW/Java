import java.util.ArrayList;
import java.util.List;

public class Test{
    public static void main(String[] args) {
        List<String> list = print("abc".toCharArray());
//        List<String> list = printSubString("abc");
        for (String str : list){
            System.out.println(str);
        }
    }
    public static List<String> print(char[] chs){
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < chs.length; i ++){
            for (int j = list.size() - 1; j >= 0; j--){
                list.add(list.get(j) + chs[i]);
            }
        }
        return list;
    }

    public static List<String> printSubString(String str){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i ++){
            for (int j = i + 1; j <= str.length(); j++){
                list.add(str.substring(i,j));
            }
        }
        return list;
    }
}