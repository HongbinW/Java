import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.equals(""))
                break;
            if(s.contains("joker JOKER")){
                System.out.println("joker JOKER");
                continue;
            }
            String[] strs = s.split("-");
            String p1 = strs[0];
            String p2 = strs[1];
            if(p1.equals("") || p2.equals("")){
                break;
            }
            String[] strs1 = p1.split(" ");
            String[] strs2 = p2.split(" ");

            String query = "345678910JQKA2";
            if(strs1.length == strs2.length){
                int q1 = query.indexOf(strs1[0]);
                int q2 = query.indexOf(strs2[0]);
                String res = q1 > q2 ? p1 : p2;
                System.out.println(res);
            }
            else{
                if(strs1.length == 4){
                    System.out.println(p1);
                }else if(strs2.length == 4){
                    System.out.println(p2);
                }else{
                    System.out.println("ERROR");
                }
            }
        }
    }
}
