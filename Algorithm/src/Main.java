import java.util.Scanner;

/**
 * @Author: HongbinW
 * @Date: 2019/4/2 19:58
 * @Version 1.0
 * @Description:
 */
public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String str = in.nextLine();
//            char[] c = str.toCharArray();
//            reserve(c,0,str.length()-1);
//            String st = new String(c);
//            reserveChar(c);
//            System.out.println(c);
//        }
//    }
//    private static void reserve(char[] c, int start ,int end){
//        if(c == null){
//            return;
//        }
//        while(start <= end){
//            char temp = c[start];
//            c[start++] = c[end];
//            c[end--] = temp;
//        }
//    }
//
//    private static void reserveChar(char[] c){
//        //记录第一个点
//        int re = 0;
//        int i;
//        for(i = 0; i < c.length && re< c.length;i++){
//            if((c[i] - 'a' >= 0 && c[i]- 'a'<26)||(c[i]-'A' >=0 && c[i]-'A' < 26)){
//
//            }else{
//                if(re != i)
//                    reserve(c,re,i-1);
//                re=i+1;
//            }
//        }
//        reserve(c,re,i-1);
//    }

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
            String str = in.nextLine();
            String[] st = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = st.length-1; i >= 0; i--){
                int len = st[i].length();
                char c = st[i].charAt(len-1);
                if(c >= 'a'&& c <='z' ||c>='A'&&c<='Z'){

                }else {
                    st[i] = c + st[i].substring(0, len - 1);
                }
                sb.append(st[i]);
                if(i != 0) {
                    sb.append(" ");
                }
            }
        System.out.println(sb.toString());
        }
    }
}

