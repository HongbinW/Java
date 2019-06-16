package JZOffer.J_knowledgeTransfer;

import java.util.ArrayList;

public class M57_Q2_FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int left = 1;
        int right = 2;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        temp.add(left);
        temp.add(right);
        int curSum = left + right;
        while (left <= (sum+1)/2){
            if(curSum < sum){
                right++;
                temp.add(right);
                curSum += right;
            }else if (curSum > sum){
                curSum -= left;
                left ++;
                temp.remove(0);
            }else{
                res.add(new ArrayList<>(temp));
                right ++;
                temp.add(right);
                curSum += right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new M57_Q2_FindContinuousSequence().FindContinuousSequence(15);
        for (ArrayList<Integer> ele:res){
            for (int i : ele){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
