package JZOffer.K_AbstractToModel;

public class M63_StackMaxProfit {
    public int stackMaxProfit_Solution(int[] price){
        int[] arr = new int[price.length];
        for (int i = 1; i < price.length; i ++){
            for (int j = 0; j < i; j ++){
                arr[i] = Math.max(arr[i],price[i] - price[j]);
            }
        }
        int res = arr[0];
        for (int i = 1; i < arr.length; i++){
            res = Math.max(res,arr[i]);
        }
        return res;
    }

    public int stackProfit(int[] price){
        int min = price[0];
        int maxDiff = price[1] - price[0];
        for (int i = 2; i < price.length; i ++){
            if (price[i-1] < min){
                min = price[i-1];
            }
            maxDiff = Math.max(maxDiff,price[i] - min);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(new M63_StackMaxProfit().stackMaxProfit_Solution(new int[]{9,11,8,5,7,12,16,14}));
        System.out.println(new M63_StackMaxProfit().stackProfit(new int[]{9,11,8,5,7,12,16,14}));

    }
}
