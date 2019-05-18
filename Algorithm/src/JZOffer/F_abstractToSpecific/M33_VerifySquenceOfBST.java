package JZOffer.F_abstractToSpecific;

public class M33_VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0 || sequence == null){
            return true;
        }
        return verifySeqOfBST(sequence,0,sequence.length-1);
    }

    public static boolean verifySeqOfBST(int[] seq, int start, int end){
        if(end == start || end < start)
            return true;
        int i = start;
        boolean flag = false;   //碰到第一个比seq[end]大的之后就要都比seq[end]大
        int off = end-1;
        for(; i < end - 1; i++){
            if(seq[i] > seq[end]){
                flag = true;
            }
            if(flag && seq[i] < seq[end]){
                return false;
            }
            if(seq[i] < seq[end] && seq[i+1] >= seq[end])
                off = i;
        }
        return verifySeqOfBST(seq,start,off) && verifySeqOfBST(seq,off+1,end-1);
    }

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{1,2,3,4,5}));
    }
}
