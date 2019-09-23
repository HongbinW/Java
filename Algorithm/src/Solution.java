class Solution {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int c = 0;
        byte[] chs = new byte[num1.length()+num2.length()+1];
        for(int i = num2.length() - 1; i >= 0; i --){
            int index = num2.length() - i - 1;
            for(int j = num1.length() - 1; j >= 0; j --){
                int temp = chs[index] + (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + c;
                chs[index++] = (byte)(temp % 10);
                c = temp / 10;
            }
            if (c != 0){
                chs[index++] = (byte)c;
                c = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = chs.length-1; i >= 0; i --){
            if (sb.length() == 0 && chs[i] == 0){
                continue;
            }
            sb.append(chs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "45"));
    }
}