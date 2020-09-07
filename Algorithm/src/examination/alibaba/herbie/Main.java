package examination.alibaba.herbie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()){
//            String base = sc.nextLine();
//            String target = sc.nextLine();
        String base = "acdkef";
        String target = "defack";
            System.out.println(minMove(base,target));
//        }
    }
    public static int minMove(String base, String target){
        if(base == null || base.length() == 0 || target == null || target.length() == 0 || base.length() != target.length()){
            return -1;
        }
        if(!isValid(base,target)){
            return -1;
        }
        int bIndex = 0;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        while (bIndex < base.length()){
            int start = 0;
            if(map.containsKey(base.charAt(bIndex))){
                start = map.get(base.charAt(bIndex)) + 1;
            }
            int cur = target.indexOf(base.charAt(bIndex),start);
            map.put(base.charAt(bIndex),cur);
            if(list.size() == 0 || list.get(list.size()-1) < cur){
                list.add(cur);
            }else{
                searchBinary(list,cur);
            }
            bIndex ++;
        }
        return base.length()-list.size();
    }
    public static void searchBinary(ArrayList<Integer> list,int target){
        int l = 0,r = list.size()-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(list.get(mid) < target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        list.set(l,target);
    }

    public static boolean isValid(String base, String target){
        int[] arr = new int[26];
        for(int i = 0; i < base.length(); i ++){
            arr[base.charAt(i)-'a']++;
        }
        for (int j = 0; j < target.length(); j++){
            arr[target.charAt(j) - 'a'] --;
            if(arr[target.charAt(j) - 'a'] > 0){
                return false;
            }
        }
        return true;
    }

    public static int process(String base, String target){
        int bIndex = 0;
        int tIndex = 0;
        int count = 0;
        while (bIndex < base.length() && tIndex < target.length()){
            while (bIndex < base.length() && target.charAt(tIndex) != base.charAt(bIndex)){
                bIndex ++;
            }
            if (bIndex < base.length() && target.charAt(tIndex) == base.charAt(bIndex)){
                count ++;
                bIndex ++;
                tIndex ++;
            }
        }
        return base.length() - count;
    }
    public static int process2(String base, String target){
        if(isValid(base,target)){
            return -1;
        }
        int bIndex = 0;
        int tIndex = 0;
        int count = 0;
        while (bIndex < base.length() && tIndex < target.length()){
            if (target.charAt(tIndex) != base.charAt(bIndex)){
                bIndex ++;
            }else{
                count ++;
                bIndex ++;
                tIndex ++;
            }
        }
        return base.length() - count;
    }
}
