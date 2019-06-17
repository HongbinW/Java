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

    public static void main(String[] args) {
        System.out.println(new M61_isContinuous().isContinuous(new int[]{0,1,3,4,5}));
    }
}
