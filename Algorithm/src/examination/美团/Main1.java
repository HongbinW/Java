package examination.美团;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int T = Integer.parseInt(sc.nextLine());
        String[] strs = new String[T];
        for (int i = 0; i < T; i ++){
            strs[i] = sc.nextLine();
        }
        for (int i = 0; i < T; i ++){
            process(strs[i].toCharArray());
        }
    }
    public static void process(char[] chs){
        boolean hasNum = false;
        if (!(chs[0] >= 'a' && chs[0] <= 'z' || chs[0] >= 'A' && chs[0] <= 'Z')){
            System.out.println("Wrong");
            return;
        }
        int index = 1;
        while (index < chs.length){
            if (chs[index] >= '0' && chs[index] <= '9'){
                hasNum = true;
                index ++;
            }else if ((chs[index] >= 'a' && chs[index] <= 'z' || chs[index] >= 'A' && chs[index] <= 'Z')) {
                index++;
            }else{
                System.out.println("Wrong");
                return;
            }
        }
        if (hasNum){
            System.out.println("Accept");
        }else{
            System.out.println("Wrong");
        }
    }
}