package examination.HuaWei.huawei_2016;

import java.util.Scanner;

public class Poke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.equals(""))
                break;
            String[] strs = s.split("-");
            String poke1 = strs[0];
            String poke2 = strs[1];
            if(poke1.equals("joker JOKER") || poke2.equals("joker JOKER")){
                System.out.println(poke1);
                continue;
            }else if(poke1.charAt(0) == poke1.charAt(poke1.length()-1)
                && poke2.charAt(0) == poke2.charAt(poke2.length() - 1)){
                if(poke1.charAt(0) > poke2.charAt(0)){
                    System.out.println(poke1);
                    continue;
                }else{
                    System.out.println(poke2);
                    continue;
                }
            }else if(poke1.charAt(0) == poke1.charAt(poke1.length()-1)){
                System.out.println(poke1);
                continue;
            }else if(poke2.charAt(0) == poke2.charAt(poke2.length() - 1)){
                System.out.println(poke2);
                continue;
            }else {
                int[] p1 = seq(poke1);
                int[] p2 = seq(poke2);
                if (p1.length != p2.length) {
                    System.out.println("ERROR");
                    continue;
                }
                switch (p1.length){
                    case 5:
                        process_shunzi(p1,p2,poke1,poke2);
                    case 3:
                        process_three(p1,p2,poke1,poke2);
                    case 2:
                        process_three(p1,p2,poke1,poke2);
                        default:
                            process_gezi(p1,p2,poke1,poke2);
                }
            }
        }
    }
    public static int[] seq(String str){
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0 ; i < strs.length; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        return arr;
    }
    public static boolean shunzi(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1] + 1){
                return false;
            }
        }
        return true;
    }
    public static void process_shunzi(int[] p1,int[] p2,String poke1,String poke2){
        if(shunzi(p1) && shunzi(p2)){
            if(p1[0] > p2[0]){
                System.out.println(poke1);
            }else{
                System.out.println(poke2);
            }
        }else if (!shunzi(p1) && !shunzi(p2)){
            process_gezi(p1,p2,poke1,poke2);
        }else{
            System.out.println("ERROR");
        }
    }
    public static void process_gezi(int[] p1,int[] p2,String poke1,String poke2){
        for(int i = p1.length-1; i >= 0; i--){
            if(p1[i] > p2[i]){
                System.out.println(poke1);
                break;
            }else{
                System.out.println(poke2);
                break;
            }
        }
    }

    public static boolean three(int[] p1){
        for(int i = 1; i < p1.length; i++){
            if(p1[i] == p1[i-1]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void process_three(int[] p1,int[] p2,String poke1,String poke2){
        if(three(p1) && three(p2)){
            if(p1[0] > p2[0]){
                System.out.println(poke1);
            }else{
                System.out.println(poke2);
            }
        }else if (!shunzi(p1) && !shunzi(p2)){
            process_gezi(p1,p2,poke1,poke2);
        }else{
            System.out.println("ERROR");
        }
    }
}
