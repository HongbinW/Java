package examination.ByteDance.SummerCamp;

import java.util.Scanner;
//字符串，将%和#之间的部分重复%前面数字的次数
//比如3%g2%n## 则结果应该是gnngnngnn
//3%acm#2%acm#  acmacmacmacmacm
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.equals(""))
                break;
            while (true) {
                int start = str.lastIndexOf("%");
                int end = str.substring(start >= 0 ? start : 0).indexOf("#")+start;
                if(start < 0 || end < 0){
                    break;
                }
                String copyStr = str.substring(start+1,end);
                int index = start - 1;  //记录第一段截止的位置
                while(index >= 0 && str.charAt(index) > '0' && str.charAt(index) < '9'){
                    index--;
                }
                int count = Integer.parseInt(str.substring(index+1,start));
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0,index+1));
                while(count > 0){
                    sb.append(copyStr);
                    count --;
                }
                if(str.length() > end + 1) {
                    sb.append(str.substring(end+1));
                }
                str = sb.toString();
            }
            System.out.println(str);
        }
    }
}
