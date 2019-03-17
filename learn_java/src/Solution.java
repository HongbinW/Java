class Solution {
    public String addBinary(String a, String b) {
        int c = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < a.length() || i < b.length() || c == 1){
            int a1 = i >= a.length() || i < 0 ? 0 : a.charAt(a.length()-1-i)-48;
            int b1 = i >= b.length() || i < 0 ? 0 : b.charAt(b.length()-1-i)-48;
            int sum = a1 + b1 + c;
            c = sum > 1 ? 1 : 0;
            sb.append(sum%2);
            i++;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1101","11"));
    }
}