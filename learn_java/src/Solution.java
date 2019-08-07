public class Solution{
    public static void main(String[] args) {
        System.out.println(new Solution().process(3,3));
    }

    public int process(int N, int K){
        if (N < 2)
            return 0;
        return (N-2)*(K-1) + K-2;
    }
}