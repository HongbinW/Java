import java.util.*;

public class Test{
    static class ListNode{
        int value;
        ListNode next;

        public ListNode(){
            this(0);
        }

        public ListNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        for(int i = 0; i < strs.length; i++){
            String[] strings = strs[i].split("~");
            String mask = strings[1];
            if(isValid(mask) != validMaskCode(mask)){
                System.out.print(strings[0] + "~");
                System.out.println(mask);
            }
        }
    }
    public static boolean isValid(String str){
        String[] strs = str.split("\\.");
        boolean state = false;
        for(int i = 0; i < strs.length; i++) {
            int value = Integer.parseInt(strs[i]);
            int b = 0b10000000;
            while(!state){
                if(b == 0){
                    break;
                }
                if((value & b) == b)
                    b = b >> 1;
                else{
                    state = true;

                }
            }
            while(state && (value & b) == 0){
                if(b == 0){
                    break;
                }
                b = b >> 1;
            }
            if(b != 0)
                return false;
        }
        return true;
    }
    private static boolean validMaskCode(String maskCode) {
        boolean res = true;
        String[] nums = maskCode.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            int n = Integer.valueOf(num);
            sb.append(binaryString(n));
        }
        int firstIndexOf0 = sb.indexOf("0");
        int lastIndexOf1 = sb.lastIndexOf("1");
        if (firstIndexOf0 < lastIndexOf1) {
            res = false;
        }
        return res;
    }
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }
}


