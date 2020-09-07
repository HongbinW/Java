package examination.HuaWei.qiuzhao2021;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String oriData = sc.nextLine();
        int start = sc.nextInt();
        int total = sc.nextInt();
        String[] strs = oriData.split(" ");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = start-1; i < strs.length && total > 0; i ++){
            sb.append(strs[i]);
            count ++;
            total --;
            if (count == 20){
                count = 0;
                sb.append("\n");
                continue;
            }
            sb.append(";");
        }
        System.out.println(sb.subSequence(0,sb.length()-1).toString());
    }
}