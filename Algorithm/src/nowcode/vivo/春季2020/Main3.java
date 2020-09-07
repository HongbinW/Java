package nowcode.vivo.春季2020;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/31
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(new Main3().new Solution().solution(11));
    }
    // 更简洁
    static int solution(int n) {
        // write code here
        int ans = 0;
        for(int i=1; n>0; ++i){
            ans += i * Math.min(i, n);  //第i组，共Math.min(i,n)个。
            n -= i; //减掉i个
        }
        return ans;
    }
    public class Solution {
        /**
         *
         * @param n int整型 第n天
         * @return int整型
         */
        public int solution (int n) {
            int num = getNum(n);
            int res = calJC(num);
            for (int i = calSum(num); i < n; i ++){
                res += num + 1;
            }
            return res;
        }
        public int calJC(int n){
            int res = 0;
            for (int i = 1; i <= n; i ++){
                res += i * i;
            }
            return res;
        }
        public int calSum(int n){
            return n * (n + 1) / 2;
        }
        // 获取n对应的前一段时间的件数
        public int getNum(int n){
            int left = 0;
            int right = n;
            while (left <= right){
                int mid = left + (right - left) / 2;
                int tmp = calSum(mid);
                if(tmp == n){
                    return mid;
                }else if (tmp > n){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            return right;
        }
    }
}
