package JZOffer.J_knowledgeTransfer;

public class M56_Q1_FindNumsAppearOnce {
    //num1和num2是长度为1的数组，num1[0]和num2[0]即为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int standard = 0;
        for (int i = 0 ; i < array.length; i++){
            standard ^= array[i];
        }
        int index = firstOne(standard);
        for (int i = 0; i < array.length; i++){
            if (divide(array[i],index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    public int firstOne(int target){
        int index = 0;
        while ((target & 1) == 0){
            target = target >> 1;
            index ++;
        }
        return index;
    }

    public boolean divide(int target, int index){
        target = target >> index;
        return (target & 1) == 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[1];
        int[] arr2 = new int[1];
        new M56_Q1_FindNumsAppearOnce().FindNumsAppearOnce(new int[] {2,4,3,6,3,2,5,5},arr1,arr2);
        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
    }

}
