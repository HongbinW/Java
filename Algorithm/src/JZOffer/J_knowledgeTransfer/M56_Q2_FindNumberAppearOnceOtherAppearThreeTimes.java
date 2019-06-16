package JZOffer.J_knowledgeTransfer;

public class M56_Q2_FindNumberAppearOnceOtherAppearThreeTimes {
    //未OJ
    public int findNumber(int[] arr){
        int[] help = new int[32];
        for (int i = 0 ; i < arr.length; i ++) {
            int bitIndex = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = bitIndex & arr[i];
                if (bit != 0){
                    help[j] ++;
                }
                bitIndex = bitIndex << 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 32; i ++){
            if(help[i] % 3 == 0){
                sb.append(0);
            }else{
                sb.append(1);
            }
        }
        return Integer.parseInt(sb.toString(),2);
    }

    public static void main(String[] args) {
        System.out.println(new M56_Q2_FindNumberAppearOnceOtherAppearThreeTimes().findNumber(new int[]{1,2,2,2,4,4,4,1,1,3,5,5,5}));
    }
}
