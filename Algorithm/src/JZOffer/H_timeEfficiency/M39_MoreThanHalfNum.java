package JZOffer.H_timeEfficiency;

public class M39_MoreThanHalfNum {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int res = array[0];
        int count = 1;
        for (int i = 1 ; i < array.length; i ++){
            if(array[i] == res)
                count++;
            else{
                count--;
                if(count <= 0){
                    res = array[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] == res)
                count++;
        }
        return count > array.length/2 ? res : 0;
    }

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }
}
