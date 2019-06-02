package examination.HuaWei.huawei_2019;

import java.util.ArrayList;
import java.util.Scanner;
//DFS
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int gifts = sc.nextInt();
            int kids = sc.nextInt();
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            dfs(gifts,kids,res,list);
            for (ArrayList ele : res){
                for (Object i : ele){
                    System.out.print((int)i);
                }
                System.out.println();
            }
        }
    }

    public static void dfs(int gifts, int kids, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list){
        if (gifts == 0 && kids == 0){
            res.add(new ArrayList<>(list));
            return;
        }else if (kids == 0 && gifts > 0)
            return;
        else{
            for (int i = 0; i <= gifts; i++){
                list.add(i);
                dfs(gifts-i,kids-1,res,list);
                list.remove(list.size()-1);
            }
        }
    }
}
