package JZOffer.K_AbstractToModel;

import java.util.Arrays;

public class M61_isContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5){
            return false;
        }
        Arrays.sort(numbers);
        int size = 0;
        int i = 0;
        while (i < numbers.length && numbers[i] == 0){
            size ++;
            i ++;
        }
        for (; i < numbers.length - 1; i++){
            if (numbers[i] + 1 == numbers[i + 1]){
                continue;
            }else{
                if(numbers[i] != numbers[i+1] && numbers[i + 1] - numbers[i] - 1 <= size){
                    size -= numbers[i+1]-numbers[i] - 1;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    //不排序
    public boolean isContinuous2(int [] numbers) {
        int[] arr = new int[14];
        for (int i = 0; i < numbers.length; i ++){
            arr[numbers[i]] ++;
        }
        int count = 0;
        boolean flag = false;
        for (int i = 1; i < arr.length; i ++){
            if (arr[i] != 0){
                count ++;
                flag = true;
            }
            else if (count < 5 && flag){
                arr[0] --;
                if (arr[0] < 0){
                    return false;
                }
                count ++;
            }
        }
        return count == 5;
    }

    public static void main(String[] args) {
        System.out.println(new M61_isContinuous().isContinuous(new int[]{0,1,3,4,5}));
    }
}
