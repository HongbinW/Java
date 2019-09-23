package JZOffer.A_dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class M3_Dupulicate {
    private class Q2{
        public ArrayList<Integer> duplicate(int[] arr){
            HashMap<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i],map.get(arr[i]) + 1);
                }else{
                    map.put(arr[i],1);
                }
            }
            Set set = map.keySet();
            Iterator<Integer> i = set.iterator();
            while(i.hasNext()){
                int x = i.next();
                if(map.get(x) > 1){
                    list.add(x);
                }
            }
            return list;
        }
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        fast = 0;
        while(slow != fast){    //找环入口，因为肯定是因为有相同的，才会成环
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,4,3,2,6,7};
        System.out.println(new M3_Dupulicate().new Q2().duplicate(arr));
    }
}

