import java.util.ArrayList;

public class Solution {
    public static int GetUglyNumber_Solution(int index) {
        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        while(list.size() - 1 <= index){
            while(list.get(twoIndex) * 2 <= list.get(list.size()-1)){
                twoIndex ++;
            }
            while(list.get(threeIndex) * 3 <= list.get(list.size()-1)){
                threeIndex ++;
            }
            while(list.get(fiveIndex) * 5 <= list.get(list.size()-1)){
                fiveIndex ++;
            }

            int curTwo = list.get(twoIndex) * 2;
            int curThree = list.get(threeIndex) * 3;
            int curFive = list.get(fiveIndex) * 5;

            int temp = curTwo < curThree ? 2 : 3;
            temp =  temp == 2 ? (curTwo < curFive ? 2 : 5 ) : (curThree < curFive ? 3 : 5);

            if(temp == 2){
                list.add(curTwo);
                twoIndex ++;
            }else if(temp == 3){
                list.add(curThree);
                threeIndex ++;
            }else{
                list.add(curFive);
                fiveIndex ++;
            }
        }
        return list.get(index);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(GetUglyNumber_Solution(i));
        }
    }
}