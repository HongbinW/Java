public class Solution{
    public static void main(String[] args) {
        int n = -3;
        n = n & 0xffffffff;
        System.out.println(n);
        System.out.println(Integer.bitCount(n));
    }
}